package uk.bbc.countmeup.main.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import uk.bbc.countmeup.main.Election;
import uk.bbc.countmeup.main.User;

import static org.junit.Assert.assertEquals;

public class ElectionTest {

    Election sut;
    User mockUser = Mockito.mock(User.class);

    @Before
    public void setUp() {
        sut = new Election();
    }

    @Test
    public void whenGetVotesIsCalledVotesAreReturnedCorrectly(){
        int[] votes = sut.getVotes();
        assertEquals(votes.length, 5);
    }

    @Test
    public void whenGetCandidatesIsCalledCandidatesAreReturnedCorrectly(){
        String[] candidates = sut.getCanditates();
        assertEquals(candidates.length, 5);
    }

    @Test
    public void whenAVoteIsPlacedAgainistACanditateTheirVoteIncreasesByOne(){
        sut.vote("Red", mockUser);
        int[] votes = sut.getVotes();
        assertEquals(votes[0], 1);
    }


    @Test
    public void voteShouldBeCountedSuccessfullyIfUserHasVotedLessThanThreeTimes(){
        sut.getVotes();
        assertEquals(true, sut.vote("Red", mockUser));
    }

    @Test
    public void voteShouldNotBeCountedSuccessfullyIfUserHasVotedThreeTimes(){
        Mockito.when(mockUser.getVotes()).thenReturn(3);
        assertEquals(false, sut.vote("Red", mockUser));
    }

    @Test
    public void voteShouldNotBeCountedSuccessfullyIfUserHasVotedMoreThanThreeTimesForThatElection(){
        Mockito.when(mockUser.getVotes()).thenReturn(5);
        assertEquals(false, sut.vote("Red", mockUser));
    }

}
