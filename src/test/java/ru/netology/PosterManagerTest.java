package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PosterManagerTest {
    String[] FilmsFive = new String[]{"Film1", "Film2", "Film3", "Film4", "Film5"};
    String[] FilmsNine = new String[]{"Film1", "Film2", "Film3", "Film4", "Film5", "Film6", "Film7", "Film8", "Film9"};
    String[] FilmsTen = new String[]{"Film1", "Film2", "Film3", "Film4", "Film5", "Film6", "Film7", "Film8", "Film9", "Film10"};
    String[] FilmsMoreTen = new String[]{"Film1", "Film2", "Film3", "Film4", "Film5", "Film6", "Film7", "Film8", "Film9", "Film10", "Film11"};


    @Test
    void addOneMovie() {
        PosterManager poster = new PosterManager();

        poster.add("Film1");

        String[] expected = new String[]{"Film1"};
        String[] actual = poster.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void moviePlusMovie() {
        PosterManager poster = new PosterManager();
        poster.setMoveList(FilmsFive);

        poster.add("Film6");

        String[] expected = new String[]{"Film1", "Film2", "Film3", "Film4", "Film5", "Film6"};
        String[] actual = poster.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLast() {
        PosterManager poster = new PosterManager();
        poster.setMoveList(FilmsFive);

        poster.findLast();

        String[] expected = new String[]{"Film5", "Film4", "Film3", "Film2", "Film1"};
        String[] actual = poster.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void addAndFindLast() {
        PosterManager poster = new PosterManager();

        poster.add("Film1");
        poster.add("Film2");
        poster.add("Film3");

        poster.findLast();

        String[] expected = new String[]{"Film3", "Film2", "Film1"};
        String[] actual = poster.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void NineFilmAndFindLast() {
        PosterManager poster = new PosterManager();
        poster.setMoveList(FilmsNine);

        poster.findLast();

        String[] expected = new String[]{"Film9", "Film8", "Film7", "Film6", "Film5", "Film4", "Film3", "Film2", "Film1"};
        String[] actual = poster.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    void TenFilmAndFindLast() {
        PosterManager poster = new PosterManager();
        poster.setMoveList(FilmsTen);

        poster.findLast();

        String[] expected = new String[]{"Film10", "Film9", "Film8", "Film7", "Film6", "Film5", "Film4", "Film3", "Film2", "Film1"};
        String[] actual = poster.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void MaxFilmAndFindLast() {
        PosterManager poster = new PosterManager();
        poster.setMoveList(FilmsMoreTen);

        poster.findLast();

        String[] expected = new String[]{"Film11", "Film10", "Film9", "Film8", "Film7", "Film6", "Film5", "Film4", "Film3", "Film2"};
        String[] actual = poster.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void MoreMaxGivenMaxFilmsFindLast() {
        PosterManager poster = new PosterManager(4);
        poster.setMoveList(FilmsFive);

        poster.findLast();

        String [] expected = new String[] {"Film5", "Film4", "Film3", "Film2"};
        String[] actual = poster.findAll();

        assertArrayEquals(expected, actual);

    }


}