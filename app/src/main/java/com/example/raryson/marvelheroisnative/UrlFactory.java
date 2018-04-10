package com.example.raryson.marvelheroisnative;

import com.example.raryson.marvelheroisnative.parameters.AbstractParameters;
import com.example.raryson.marvelheroisnative.parameters.CharacterParameters;
import com.example.raryson.marvelheroisnative.parameters.ComicParameters;
import com.example.raryson.marvelheroisnative.parameters.CreatorParameters;
import com.example.raryson.marvelheroisnative.parameters.EventParameters;
import com.example.raryson.marvelheroisnative.parameters.SeriesParameters;
import com.example.raryson.marvelheroisnative.parameters.StoryParameters;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import io.mikael.urlbuilder.UrlBuilder;

public class UrlFactory {

    private final String publicKey;
    private final String privateKey;

    private static final String BASE_URL = "http://gateway.marvel.com/v1/public/";
    private static final String COMICS_CHARACTERS_URL = BASE_URL + "comics/%d/characters";
    private static final String COMICS_CREATORS_URL = BASE_URL + "comics/%d/creators";
    private static final String COMICS_EVENTS_URL = BASE_URL + "comics/%d/events";
    private static final String COMICS_STORIES_URL = BASE_URL + "comics/%d/stories";
    private static final String COMICS_BY_ID_URL = BASE_URL + "comics/%d";
    private static final String COMICS_URL = BASE_URL + "comics";

    private static final String CHARACTERS_BY_ID_URL = BASE_URL + "characters/%d";
    private static final String CHARACTERS_COMICS_URL =  BASE_URL + "characters/%d/comics";
    private static final String CHARACTERS_EVENT_URL = BASE_URL + "characters/%d/events";
    private static final String CHARACTERS_STORIES_URL = BASE_URL + "characters/%d/stories";
    private static final String CHARACTERS_SERIES_URL = BASE_URL + "characters/%d/series";

    private static final String EVENTS_URL = BASE_URL + "events";
    private static final String EVENTS_BY_ID_URL = BASE_URL + "events/%d";
    private static final String EVENTS_CHARACTERS_URL = BASE_URL + "events/%d/characters";
    private static final String EVENTS_COMICS_URL = BASE_URL + "events/%d/comics";
    private static final String EVENTS_STORIES_URL = BASE_URL + "events/%d/stories";
    private static final String EVENTS_CREATORS_URL = BASE_URL + "events/%d/creators";



    public UrlFactory()
    {
        this.publicKey = "be8cbfedbe4bd908427a19cad940880f";
        this.privateKey = "e05e5aedea32aa474cce7fe42b3d5320bc8f0a17";

    }


    public String getCharactersURL(CharacterParameters characterParameters) {
        final String url = BASE_URL + "characters";
        return buildURL(url, characterParameters);
    }

    public String getCharacterURL() {
        final String url = BASE_URL + "characters";
        UrlBuilder urlBuilder = UrlBuilder.fromString(url);
        return addAuthorizationParameters(urlBuilder).toString();
    }

    public String getImagesUrl(String url) {

        UrlBuilder urlBuilder = UrlBuilder.fromString(url);
        return addAuthorizationParameters(urlBuilder).toString();
    }

    public String getCharacterURL(int characterId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(String.format(CHARACTERS_BY_ID_URL, characterId));
        return addAuthorizationParameters(urlBuilder).toString();
    }

    public String getCharactersComicsURL(ComicParameters comicParameters) {
        final String url = String.format(CHARACTERS_COMICS_URL, comicParameters.getId());
        return buildURL(url, comicParameters);
    }

    public String getCharactersEventURL(EventParameters eventParameters) {
        final String url = String.format(CHARACTERS_EVENT_URL, eventParameters.getId());
        return buildURL(url, eventParameters);
    }

    public String getCharactersStoriesURL(StoryParameters storyParameters) {
        final String url = String.format(CHARACTERS_STORIES_URL, storyParameters.getId());
        return buildURL(url, storyParameters);
    }

    public String getCharactersSeriesURL(SeriesParameters seriesParameters) {
        final String url = String.format(CHARACTERS_SERIES_URL, seriesParameters.getId());
        return buildURL(url, seriesParameters);
    }

    public String getComicsURL() {
        UrlBuilder urlBuilder = UrlBuilder.fromString(COMICS_URL);
        urlBuilder = addAuthorizationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getComicsCharactersURL(ComicParameters comicParameters) {
        final String url = String.format(COMICS_CHARACTERS_URL, comicParameters.getId());
        return buildURL(url, comicParameters);
    }

    public String getComicsCreatorsURL(CreatorParameters creatorParameters) {
        final String url = String.format(COMICS_CREATORS_URL, creatorParameters.getId());
        return buildURL(url, creatorParameters);
    }

    public String getComicsEventsURL(EventParameters eventParameters) {
        final String url = String.format(COMICS_EVENTS_URL, eventParameters.getId());
        return buildURL(url, eventParameters);
    }

    public String getComicsStoriesURL(StoryParameters storyParameters) {
        final String url = String.format(COMICS_STORIES_URL, storyParameters.getId());
        return buildURL(url, storyParameters);
    }

    public String getComicsURL(int comicId) {
        final String url = String.format(COMICS_BY_ID_URL, comicId);
        UrlBuilder urlBuilder = UrlBuilder.fromString(url);
        urlBuilder = addAuthorizationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getEventsURL() {
        UrlBuilder urlBuilder = UrlBuilder.fromString(EVENTS_URL);
        urlBuilder = addAuthorizationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getEventsURL(int eventId) {
        final String url = String.format(EVENTS_BY_ID_URL, eventId);
        UrlBuilder urlBuilder = UrlBuilder.fromString(url);
        urlBuilder = addAuthorizationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getEventsCharactersURL(EventParameters eventParameters) {
        final String url = String.format(EVENTS_CHARACTERS_URL, eventParameters.getId());
        return buildURL(url, eventParameters);
    }

    public String getEventsStoriesURL(EventParameters eventParameters) {
        final String url = String.format(EVENTS_STORIES_URL, eventParameters.getId());
        return buildURL(url, eventParameters);
    }

    public String getEventsCreatorsURL(EventParameters eventParameters) {
        final String url = String.format(EVENTS_CREATORS_URL, eventParameters.getId());
        return buildURL(url, eventParameters);
    }

    public String getEventsComicsURL(EventParameters eventParameters) {
        final String url = String.format(EVENTS_COMICS_URL, eventParameters.getId());
        return buildURL(url, eventParameters);
    }

    public String getSeriesURL() {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "series");
        urlBuilder = addAuthorizationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getSeriesURL(int seriesId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "series/" + seriesId);
        urlBuilder = addAuthorizationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getSeriesCharactersURL(SeriesParameters seriesParameters) {
        final String url = BASE_URL + "series/" + seriesParameters.getId() + "/characters";
        return buildURL(url, seriesParameters);
    }

    public String getSeriesComicsURL(SeriesParameters seriesParameters) {
        final String url = BASE_URL + "series/" + seriesParameters.getId() + "/comics";
        return buildURL(url, seriesParameters);
    }

    public String getSeriesCreatorsURL(SeriesParameters seriesParameters) {
        final String url = BASE_URL + "series/" + seriesParameters.getId() + "/creators";
        return buildURL(url, seriesParameters);
    }

    public String getSeriesStoriesURL(SeriesParameters seriesParameters) {
        final String url = BASE_URL + "series/" + seriesParameters.getId() + "/stories";
        return buildURL(url, seriesParameters);
    }

    public String getStoriesURL() {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "stories");
        urlBuilder = addAuthorizationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getStoriesURL(int storyId) {
        final String url = BASE_URL + "stories/" + storyId;
        UrlBuilder urlBuilder = UrlBuilder.fromString(url);
        urlBuilder = addAuthorizationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getStoriesCharactersURL(StoryParameters storyParameters) {
        final String url = BASE_URL + "stories/" + storyParameters.getId() + "/characters";
        return buildURL(url, storyParameters);
    }

    public String getStoriesComicsURL(StoryParameters storyParameters) {
        final String url = BASE_URL + "stories/" + storyParameters.getId() + "/comics";
        return buildURL(url, storyParameters);
    }

    public String getStoriesCreatorsURL(StoryParameters storyParameters) {
        final String url = BASE_URL + "stories/" + storyParameters.getId() + "/creators";
        return buildURL(url, storyParameters);
    }

    private <T extends AbstractParameters> String buildURL(String url, T parameters) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(url);
        urlBuilder = parameters.addParameters(urlBuilder);
        urlBuilder = addAuthorizationParameters(urlBuilder);
        return urlBuilder.toString();
    }


    private UrlBuilder addAuthorizationParameters(UrlBuilder urlBuilder)
    {
        long timeStamp = System.currentTimeMillis();
        return urlBuilder.addParameter("ts", String.valueOf(timeStamp))
                .addParameter("apikey", publicKey)
                .addParameter("hash", createHash(timeStamp));
    }

    private String createHash(long timeStamp)
    {
        String stringToHash = timeStamp + privateKey + publicKey;
        return new String(Hex.encodeHex(DigestUtils.md5(stringToHash)));
    }

}
