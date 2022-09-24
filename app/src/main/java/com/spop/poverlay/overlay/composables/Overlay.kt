package com.spop.poverlay.overlay

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.spop.poverlay.R
import com.spop.poverlay.overlay.composables.OverlayMainContent
import com.spop.poverlay.ui.theme.LatoFontFamily

//This is the percentage of the overlay that is offscreen when hidden
const val PercentVisibleWhenHidden = .00f
const val VisibilityChangeDuration = 150
val OverlayCornerRadius = 25.dp
val StatCardWidth = 105.dp
val PowerChartFullWidth = 200.dp
val PowerChartShrunkWidth = 120.dp
val BackgroundColorDefault = Color(20, 20, 20)
val BackgroundColorHidden = Color(252, 93, 72)

@Composable
fun Overlay(
    viewModel: OverlaySensorViewModel,
    height: Dp,
    locationState: State<OverlayLocation>,
    horizontalDragCallback: (Float) -> Float,
    verticalDragCallback: (Float) -> Float,
    offsetCallback: (Float, Float) -> Unit,
    onLayout: (IntSize) -> Unit
) {
    val placeholderText = "-"

    val power by viewModel.powerValue.collectAsState(initial = placeholderText)

    val powerGraph = remember { viewModel.powerGraph }
    val rpm by viewModel.rpmValue.collectAsState(initial = placeholderText)
    val resistance by viewModel.resistanceValue.collectAsState(initial = placeholderText)
    val speed by viewModel.speedValue.collectAsState(initial = placeholderText)
    val speedLabel by viewModel.speedLabel.collectAsState(initial = "")
    val timerLabel by viewModel.timerLabel.collectAsState(initial = "")

    val visible by viewModel.isVisible.collectAsState(initial = true)
    val location by remember { locationState }
    val size = remember { mutableStateOf(IntSize.Zero) }

    val backgroundColor by animateColorAsState(
        if (visible) BackgroundColorDefault else BackgroundColorHidden,
        animationSpec = TweenSpec(VisibilityChangeDuration, 0)
    )

    val maxOffset = with(LocalDensity.current) {
        (height * (1 - PercentVisibleWhenHidden)).roundToPx()
    }

    val contentAlpha by animateFloatAsState(
        if (visible) 1f else 0f,
        animationSpec = TweenSpec(VisibilityChangeDuration, 0, LinearEasing)
    )

    val timerAlpha by animateFloatAsState(
        if (visible) 1f else .2f,
        animationSpec = TweenSpec(VisibilityChangeDuration, 0, LinearEasing)
    )

    val visibilityOffset by animateIntOffsetAsState(
        if (visible) {
            IntOffset.Zero
        } else {
            when (location) {
                OverlayLocation.Top -> IntOffset(0, -maxOffset)
                OverlayLocation.Bottom -> IntOffset(0, maxOffset)
            }
        }, animationSpec = TweenSpec(VisibilityChangeDuration, 0, LinearEasing)
    )

    offsetCallback(visibilityOffset.y.toFloat(), size.value.height.toFloat())

    var horizontalDragOffset by remember { mutableStateOf(0f) }
    var verticalDragOffset by remember { mutableStateOf(0f) }

    val backgroundShape = when (location) {
        OverlayLocation.Top -> RoundedCornerShape(
            bottomStart = OverlayCornerRadius, bottomEnd = OverlayCornerRadius
        )
        OverlayLocation.Bottom -> RoundedCornerShape(
            topStart = OverlayCornerRadius, topEnd = OverlayCornerRadius
        )
    }
    Column(
        modifier = Modifier
            .wrapContentSize()
            .offset { visibilityOffset },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OverlayTimer(timerAlpha,
            timerLabel,
            { viewModel.onTimerTap() },
            { viewModel.onTimerDoubleTap() }
        )

        Box(modifier = Modifier
            .requiredHeight(height)
            .wrapContentWidth(unbounded = true)
            .onSizeChanged {
                if (it.width != size.value.width || it.height != size.value.height) {
                    size.value = it
                    onLayout(size.value)
                }
            }
            .background(
                color = backgroundColor,
                shape = backgroundShape,
            )
            .pointerInput(Unit) {
                detectDragGestures(onDrag = { change, offset ->
                    change.consume()
                    horizontalDragOffset += offset.x
                    horizontalDragOffset = horizontalDragCallback(horizontalDragOffset)

                    verticalDragOffset += offset.y
                    verticalDragOffset = verticalDragCallback(verticalDragOffset)
                }, onDragEnd = {
                    verticalDragOffset = 0f
                })
            }
            .pointerInput(Unit) {
                detectTapGestures(onTap = { viewModel.onOverlayPressed() },
                    onLongPress = { viewModel.onOverlayDoubleTap() })
            }) {

            val rowAlignment = when (location) {
                OverlayLocation.Top -> Alignment.Top
                OverlayLocation.Bottom -> Alignment.Bottom
            }

            OverlayMainContent(modifier = Modifier
                .wrapContentWidth(unbounded = true)
                .padding(horizontal = 9.dp)
                .padding(bottom = 5.dp)
                .alpha(contentAlpha),
                rowAlignment = rowAlignment,
                power = power,
                rpm = rpm,
                powerGraph = powerGraph,
                resistance = resistance,
                speed = speed,
                speedLabel = speedLabel,
                onSpeedClicked = { viewModel.onClickedSpeed() },
                onChartClicked = { viewModel.onOverlayPressed() })
        }
    }

}

@Composable
private fun OverlayTimer(
    timerAlpha: Float,
    timerLabel: String,
    onTap: () -> Unit,
    onDoubleTap: () -> Unit
) {
    Row(
        modifier = Modifier
            .alpha(timerAlpha)
            .wrapContentSize()
            .background(
                color = BackgroundColorDefault,
                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
            )
            .width(100.dp)
            .padding(horizontal = 10.dp)
            .padding(top = 1.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        onTap()
                    },
                    onDoubleTap = {
                        onDoubleTap()
                    }
                )
            },
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(.2f),
            painter = painterResource(id = R.drawable.ic_timer),
            contentDescription = null,
        )
        Text(
            timerLabel,
            color = Color.White,
            fontFamily = LatoFontFamily,
            fontSize = 19.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(.9f)
        )
    }
}