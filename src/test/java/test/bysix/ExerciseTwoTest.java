package test.bysix;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ExerciseTwoTest {

    // numberOfCountriesInTheWorld
    @Test
    public void testNumberOfCountriesInTheWorld() {
        List<ExerciseTwo.Country> countries = Arrays.asList(
                new ExerciseTwo.Country("US", Collections.singletonList("en")),
                new ExerciseTwo.Country("BE", Arrays.asList("nl", "fr", "de")),
                new ExerciseTwo.Country("NL", Arrays.asList("nl", "fy")),
                new ExerciseTwo.Country("DE", Collections.singletonList("de")),
                new ExerciseTwo.Country("ES", Collections.singletonList("es"))
        );

        int result = ExerciseTwo.numberOfCountriesInTheWorld(countries);
        assertEquals(5, result);
    }

    @Test
    public void testNumberOfCountriesInTheWorldEmptyList() {
        List<ExerciseTwo.Country> countries = Collections.emptyList();

        int result = ExerciseTwo.numberOfCountriesInTheWorld(countries);
        assertEquals(0, result);
    }

    // countryWithMostLanguagesIncludedGerman
    @Test
    public void testCountryWithMostLanguagesIncludedGerman() {
        List<ExerciseTwo.Country> countries = Arrays.asList(
                new ExerciseTwo.Country("US", Collections.singletonList("en")),
                new ExerciseTwo.Country("BE", Arrays.asList("nl", "fr", "de")),
                new ExerciseTwo.Country("NL", Arrays.asList("nl", "fy")),
                new ExerciseTwo.Country("DE", Collections.singletonList("de")),
                new ExerciseTwo.Country("ES", Collections.singletonList("es"))
        );

        Optional<ExerciseTwo.Country> result = ExerciseTwo.countryWithMostLanguagesIncludedGerman(countries);
        assertTrue(result.isPresent());
        assertEquals("BE", result.get().getCountry());
    }

    @Test
    public void testCountryWithMostLanguagesIncludedGermanWithEmptyList() {
        List<ExerciseTwo.Country> countries = Collections.emptyList();

        Optional<ExerciseTwo.Country> result = ExerciseTwo.countryWithMostLanguagesIncludedGerman(countries);
        assertFalse(result.isPresent());
    }

    @Test
    public void testCountryWithMostLanguagesIncludedGermanWithNoMatches() {
        List<ExerciseTwo.Country> countries = new ArrayList<>();
        countries.add(new ExerciseTwo.Country("US", Collections.singletonList("en")));
        countries.add(new ExerciseTwo.Country("NL", Collections.singletonList("nl")));
        countries.add(new ExerciseTwo.Country("ES", Collections.singletonList("es")));

        Optional<ExerciseTwo.Country> result = ExerciseTwo.countryWithMostLanguagesIncludedGerman(countries);
        assertFalse(result.isPresent());
    }

    // countOfficialLanguages
    @Test
    public void testCountOfficialLanguages() {
        List<ExerciseTwo.Country> countries = Arrays.asList(
                new ExerciseTwo.Country("US", Collections.singletonList("en")),
                new ExerciseTwo.Country("BE", Arrays.asList("nl", "fr", "de")),
                new ExerciseTwo.Country("NL", Arrays.asList("nl", "fy")),
                new ExerciseTwo.Country("DE", Collections.singletonList("de")),
                new ExerciseTwo.Country("ES", Collections.singletonList("es"))
        );

        int result = ExerciseTwo.countOfficialLanguages(countries);
        assertEquals(6, result);
    }

    @Test
    public void testCountOfficialLanguagesWithEmptyList() {
        List<ExerciseTwo.Country> countries = Collections.emptyList();

        int result = ExerciseTwo.countOfficialLanguages(countries);
        assertEquals(0, result);
    }

    // countryWithMostLanguages
    @Test
    public void testCountryWithMostLanguages() {
        List<ExerciseTwo.Country> countries = Arrays.asList(
                new ExerciseTwo.Country("US", Collections.singletonList("en")),
                new ExerciseTwo.Country("BE", Arrays.asList("nl", "fr", "de")),
                new ExerciseTwo.Country("NL", Arrays.asList("nl", "fy")),
                new ExerciseTwo.Country("DE", Collections.singletonList("de")),
                new ExerciseTwo.Country("ES", Collections.singletonList("es"))
        );

        Optional<ExerciseTwo.Country> result = ExerciseTwo.countryWithMostLanguages(countries);
        assertTrue(result.isPresent());
        assertEquals("BE", result.get().getCountry());
    }

    @Test
    public void testCountryWithMostLanguagesWithEmptyList() {
        List<ExerciseTwo.Country> countries = Collections.emptyList();

        Optional<ExerciseTwo.Country> result = ExerciseTwo.countryWithMostLanguages(countries);
        assertFalse(result.isPresent());
    }

    // findMostCommonOfficialLanguages
    @Test
    public void testFindMostCommonOfficialLanguages() {
        List<ExerciseTwo.Country> countries = Arrays.asList(
                new ExerciseTwo.Country("US", Collections.singletonList("en")),
                new ExerciseTwo.Country("BE", Arrays.asList("nl", "fr", "de")),
                new ExerciseTwo.Country("NL", Arrays.asList("nl", "fy")),
                new ExerciseTwo.Country("DE", Collections.singletonList("de")),
                new ExerciseTwo.Country("ES", Collections.singletonList("es"))
        );

        List<String> result = ExerciseTwo.findMostCommonOfficialLanguages(countries);
        assertEquals(Arrays.asList("de", "nl"), result);
    }

    @Test
    public void testFindMostCommonOfficialLanguagesWithEmptyList() {
        List<ExerciseTwo.Country> countries = Collections.emptyList();

        List<String> result = ExerciseTwo.findMostCommonOfficialLanguages(countries);
        assertEquals(Collections.emptyList(), result);
    }
}