package com.example.androiddevchallenge.ui.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Canvas
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.animations.rotationAnimation

@Composable
fun AnimatedDashedCircle(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.secondary
) {
    val transformation = rememberInfiniteTransition()
    val degreeState = transformation.rotationAnimation(targetValue = 360f)
    Canvas(
        modifier = modifier
    ) {
        rotate(degreeState.value) {
            val path = PathEffect.dashPathEffect(
                floatArrayOf(
                    size.width / 2,
                    size.width / 2,
                    size.width / 8,
                    size.width / 8
                ), 3f
            )
            drawCircle(
                color = color,
                style = Stroke(
                    width = 1.3f,
                    pathEffect = path
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewCircle() {
    AnimatedDashedCircle()
}