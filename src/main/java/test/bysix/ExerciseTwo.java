package test.bysix;

import java.util.*;
import java.util.stream.Collectors;

public class ExerciseTwo {

    public static void run(List<Country> allCountriesOfTheWorld) {
        var numberOfCountriesInTheWorld = numberOfCountriesInTheWorld(allCountriesOfTheWorld);
        var countryWithMostLanguagesIncludedGerman = countryWithMostLanguagesIncludedGerman(allCountriesOfTheWorld);
        var countOfficialLanguages = countOfficialLanguages(allCountriesOfTheWorld);
        var countryWithMostLanguages = countryWithMostLanguages(allCountriesOfTheWorld);
        var findMostCommonOfficialLanguages = findMostCommonOfficialLanguages(allCountriesOfTheWorld);

        System.out.println("\n");
        System.out.println("numberOfCountriesInTheWorld: " + numberOfCountriesInTheWorld );
        System.out.println("countryWithMostLanguagesIncludedGerman: " + countryWithMostLanguagesIncludedGerman);
        System.out.println("countOfficialLanguages: " + countOfficialLanguages);
        System.out.println("countryWithMostLanguages: " + countryWithMostLanguages);
        System.out.println("findMostCommonOfficialLanguages: " + findMostCommonOfficialLanguages);
    }

    //returns the number of countries in the world
    public static int numberOfCountriesInTheWorld(List<Country> allCountriesOfTheWorld) {
        return allCountriesOfTheWorld.size();
    }

    // finds the country with the most official languages, where they officially speak German (de).
    public static Optional<Country> countryWithMostLanguagesIncludedGerman(List<Country> allCountriesOfTheWorld) {
        return allCountriesOfTheWorld.stream()
                .filter(country -> country.getLanguages().contains("de"))
                .max(Comparator.comparingInt(country -> country.getLanguages().size()));
    }

    // that counts all the official languages spoken in the listed countries.
    public static int countOfficialLanguages(List<Country> countries) {
        Set<String> uniqueLanguages = new HashSet<>();
        for (Country country : countries) {
            uniqueLanguages.addAll(country.getLanguages());
        }
        return uniqueLanguages.size();
    }

    // to find the country with the highest number of official languages.
    public static Optional<Country> countryWithMostLanguages(List<Country> allCountriesOfTheWorld) {
        return allCountriesOfTheWorld.stream()
                .max(Comparator.comparingInt(country -> country.getLanguages().size()));
    }

    // to find the most common official language(s), of all countries.
    public static List<String> findMostCommonOfficialLanguages(List<Country> allCountriesOfTheWorld) {
        if (allCountriesOfTheWorld.size() == 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> languageCountMap = new HashMap<>();

        // Count the occurrences of each language
        allCountriesOfTheWorld.stream()
                .flatMap(country -> country.getLanguages().stream())
                .forEach(language -> languageCountMap.put(language, languageCountMap.getOrDefault(language, 0) + 1));

        // Find the maximum count
        int maxCount = Collections.max(languageCountMap.values());

        // Collect the languages with the maximum count
        return languageCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    static class Country {
        private String country;
        private List<String> languages;

        public Country() {}

        Country(String country, List<String> languages) {
            this.country = country;
            this.languages = languages;
        }

        public String getCountry() {
            return country;
        }

        public List<String> getLanguages() {
            return languages;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setLanguages(List<String> languages) {
            this.languages = languages;
        }

        @Override
        public String toString() {
            return "Country{" +
                    "name='" + country + '\'' +
                    '}';
        }
    }
}
