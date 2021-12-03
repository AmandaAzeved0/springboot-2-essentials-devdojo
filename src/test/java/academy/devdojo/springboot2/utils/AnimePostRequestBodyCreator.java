package academy.devdojo.springboot2.utils;

import academy.devdojo.springboot2.requests.AnimePostRequestBody;

public class AnimePostRequestBodyCreator {
    public static AnimePostRequestBody createAnimePostRequestBody(){
        return AnimePostRequestBody.builder()
                .name(AnimeCreatorForTests.createAnimeToBeSaved().getName())
                .build();
    }
}
