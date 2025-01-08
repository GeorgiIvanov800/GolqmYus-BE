package org.golqmyus.service.impl;


import org.golqmyus.model.dto.ArtistDTO;
import org.golqmyus.model.entity.ArtistEntity;
import org.golqmyus.repository.ArtistRepository;
import org.golqmyus.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    @Override
    public Optional<ArtistDTO> findById(Long id) {
        ArtistEntity artist = artistRepository.findById(id).orElse(null);
        assert artist != null;
        return Optional.of(mapToArtistDTO(artist));
    }

    @Override
    public List<ArtistDTO> getAllArtists() {
        List<ArtistEntity> artist = artistRepository.findAll();

        return artist.stream()
                .map(this:: mapToArtistDTO)
                .collect(Collectors.toList());
    }

    private ArtistDTO mapToArtistDTO(ArtistEntity artistEntity) {
        return new ArtistDTO(
                artistEntity.getId(),
                artistEntity.getNickname(),
                artistEntity.getFirstName(),
                artistEntity.getLastName(),
                artistEntity.getBornDate(),
                artistEntity.getBiography(),
                artistEntity.getPictureURL(),
                artistEntity.getCity(),
                artistEntity.getSocialMediaLinks()
        );
    }
}
