package com.baitent.thenews.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.baitent.thenews.presentation.Dimens.MediumPadding2
import com.baitent.thenews.presentation.Dimens.PageIndicatorWidth
import com.baitent.thenews.presentation.onboarding.component.OnboardingPage
import com.baitent.thenews.presentation.onboarding.component.PageIndicator

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf()
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnboardingPage(page = pages[index])
        }

        Spacer(modifier = Modifier.weight(1f))
        Row( //indicator row
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                pageSize = pages.size,
                selectedPage = pagerState.currentPage,
                modifier = Modifier.width(PageIndicatorWidth),
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {

        }

    }
}