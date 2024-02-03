package com.github.gustavoflor.dpho.structural.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ProxyTest {

    @Mock
    private ExternalService externalService;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("""
        GIVEN a proxy
        WHEN call it without reaching limit
        THEN should call external service
        """)
    void givenAProxyWhenCallItWithoutReachingLimitThenShouldCallExternalService() {
        final var proxy = new ExternalServiceProxy(externalService);

        proxy.call();
        proxy.call();

        verify(externalService, times(2)).call();
    }

    @Test
    @DisplayName("""
        GIVEN a proxy
        WHEN call it reaching limit
        THEN should throw RateLimitException
        """)
    void givenAProxyWhenCallItReachingLimitThenShouldThrowRateLimitException() {
        final var proxy = new ExternalServiceProxy(externalService);

        proxy.call();
        proxy.call();
        assertThatThrownBy(proxy::call).isInstanceOf(RateLimitException.class);

        verify(externalService, times(2)).call();
    }

}
