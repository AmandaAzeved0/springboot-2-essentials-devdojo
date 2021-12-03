package academy.devdojo.springboot2.utils;

import academy.devdojo.springboot2.domain.Anime;

public class AnimeCreatorForTests {

    public static Anime createAnimeToBeSaved(){
        return Anime.builder()
                .name("Sakura card Captor")
                .build();
    }
    public static Anime createValidAnimeWithId(){
        return Anime.builder()
                .name("Sakura card Captor")
                .id(1L)
                .build();
    }
    public static Anime createValidUpdatedAnime(){
        return Anime.builder()
                .name("Sakura card Captor editado")
                .id(1L)
                .build();
    }
}
