package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.utils.AnimeCreatorForTests;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;


@DataJpaTest
@DisplayName("Tests For Anime Repository")
class AnimeRepositoryTest {
    @Autowired
    private AnimeRepository animeRepository;

//    private Anime AnimeCreatorForTests.createAnimeToBeSaved(){
//        return Anime.builder()
//                .name("Sakura card Captor")
//                .build();
//    }

    @Test
    @DisplayName("save anime when successful")
    void save_PersistsAnime_WhenSuccessful(){
        Anime animeToBeSaved = AnimeCreatorForTests.createAnimeToBeSaved();
        Anime animeSaved = this.animeRepository.save(animeToBeSaved);

        Assertions.assertThat(animeSaved).isNotNull();
        Assertions.assertThat(animeSaved.getId()).isNotNull();
        Assertions.assertThat(animeSaved.getName()).isEqualTo(animeToBeSaved.getName());
    }

    @Test
    @DisplayName("update anime when successful")
    void save_UpdatesAnime_WhenSuccessful(){
        Anime animeToBeSaved = AnimeCreatorForTests.createAnimeToBeSaved();
        Anime animeSaved = this.animeRepository.save(animeToBeSaved);
        animeSaved.setName("Overlord");

        Assertions.assertThat(animeSaved).isNotNull();
        Assertions.assertThat(animeSaved.getId()).isNotNull();
        Assertions.assertThat(animeSaved.getName()).isEqualTo(animeToBeSaved.getName());
    }

    @Test
    @DisplayName("delete anime when successful")
    void remove_DeletesAnime_WhenSuccessful(){
        Anime animeToBeSaved = AnimeCreatorForTests.createAnimeToBeSaved();
        Anime animeSaved = this.animeRepository.save(animeToBeSaved);
        this.animeRepository.delete(animeSaved);
        Optional<Anime> byId = this.animeRepository.findById(animeSaved.getId());

        Assertions.assertThat(byId.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("find one or a list of animes  when successful")
    void findByName_returnsListOfAnime_WhenSuccessful(){
        Anime animeToBeSaved = AnimeCreatorForTests.createAnimeToBeSaved();
        Anime animeSaved = this.animeRepository.save(animeToBeSaved);
        String name = animeSaved.getName();
        List<Anime> animes = this.animeRepository.findByName(name);

        Assertions.assertThat(animes)
                .isNotEmpty()
                .contains(animeSaved);
    }

    @Test
    @DisplayName("returns a empty list when no anime is found")
    void findByName_returnsEmptyList_WhenAnimeIsNotFound(){
        List<Anime> animes = this.animeRepository.findByName("test name");

        Assertions.assertThat(animes).isEmpty();
    }

    @Test
    @DisplayName("Save throws exception when the name atributte is empty")
    void save_ThrowsException_WhenNameIsEmpty(){
        Anime anime = AnimeCreatorForTests.createAnimeToBeSaved();

        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(()->this.animeRepository.save(anime))
                .withMessageContaining("anime name cannot be empty");

//Outra Forma
//        Assertions.assertThatThrownBy(()->this.animeRepository.save(anime))
//                .isInstanceOf(ConstraintViolationException.class);

    }
}