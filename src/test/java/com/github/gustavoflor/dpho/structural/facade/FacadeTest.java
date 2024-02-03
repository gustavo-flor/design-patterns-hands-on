package com.github.gustavoflor.dpho.structural.facade;

import com.github.gustavoflor.dpho.structural.facade.lib.SpanTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class FacadeTest {

    @Mock
    private SpanTracker spanTracker;

    @InjectMocks
    private TraceFacade traceFacade;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("""
        GIVEN a runnable
        WHEN track
        THEN should abstract trace
        """)
    void givenARunnableWhenTrackThenShouldAbstractTrace() {
        traceFacade.track(() -> System.out.println("Tracking..."));

        verify(spanTracker).next("track");
        verify(spanTracker).setEvent("start-track");
        verify(spanTracker).setEvent("end-track");
    }

}
