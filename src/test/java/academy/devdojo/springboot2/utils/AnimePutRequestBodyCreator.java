package academy.devdojo.springboot2.utils;

import academy.devdojo.springboot2.requests.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {
    public static AnimePutRequestBody createAnimePutRequestBody(){
        return AnimePutRequestBodyCreator.builder()
                .id(AnimeCreatorForTests.createValidUpdatedAnime().getId())
                .name(AnimeCreatorForTests.createValidUpdatedAnime().getName())
                .build();
    }
}
