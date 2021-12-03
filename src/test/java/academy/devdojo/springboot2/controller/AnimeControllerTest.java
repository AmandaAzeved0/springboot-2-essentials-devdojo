package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.utils.AnimeCreatorForTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import org.assertj.core.api.Assertions;


@ExtendWith(SpringExtension.class)
class AnimeControllerTest {
    @InjectMocks //itilizado quando quero testar a classe em si ex.:AnimeController
    private AnimeController animeController;
    @Mock // utilizado para testar as classes utilizadas dentro da classe testada com o injectmocks ex.: AnimeService
    private AnimeService animeServiceMock;

    @BeforeEach //antes de cada teste faça isso
    void SetUp(){
        PageImpl<Anime> animePage = new PageImpl<>(List.of(AnimeCreatorForTests.createValidAnimeWithId()));
        BDDMockito.when(animeServiceMock.listAll(ArgumentMatchers.any()))
                .thenReturn(animePage);
    }

    @Test
    @DisplayName("Returns a list of animes inside a page object when sicccessful")
    void list_returnsListOfAnimesInsidePageObject_whenSuccessful(){
        String expectedName = AnimeCreatorForTests.createValidAnimeWithId().getName();
        Page<Anime> animePage = animeController.list(null).getBody();
        Assertions.assertThat(animePage).isNotNull();
        Assertions.assertThat(animePage.toList())
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(animePage.toList().get(0).getName()).isEqualTo(expectedName);
    }

}