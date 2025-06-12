package com.example.weatherapp.utils

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.weatherapp.ui.theme.BackgroundColorDay
import com.example.weatherapp.ui.theme.BackgroundColorNight
import com.example.weatherapp.ui.theme.BlurColor
import com.example.weatherapp.ui.theme.CardAboveColorDay
import com.example.weatherapp.ui.theme.CardAboveColorNight
import com.example.weatherapp.ui.theme.CardAboveLineColorDay
import com.example.weatherapp.ui.theme.CardBackgroundBorderColorDay
import com.example.weatherapp.ui.theme.CardBackgroundBorderColorNight
import com.example.weatherapp.ui.theme.CardBackgroundColorDay
import com.example.weatherapp.ui.theme.CardBackgroundColorNight
import com.example.weatherapp.ui.theme.CardContentAboveColorDay
import com.example.weatherapp.ui.theme.CardContentAboveColorNight
import com.example.weatherapp.ui.theme.CardContentAboveLineColorNight
import com.example.weatherapp.ui.theme.CardContentColorDay
import com.example.weatherapp.ui.theme.CardContentColorNight
import com.example.weatherapp.ui.theme.CardSubContentColorDay
import com.example.weatherapp.ui.theme.CardSubContentColorNight
import com.example.weatherapp.ui.theme.IconLocationColorDay
import com.example.weatherapp.ui.theme.IconLocationColorNight
import com.example.weatherapp.ui.theme.NightBlurColor
import com.example.weatherapp.ui.theme.NightSmallBlurColor
import com.example.weatherapp.ui.theme.SmallBlurColor
import com.example.weatherapp.ui.theme.TextSubTitleColorDay
import com.example.weatherapp.ui.theme.TextSubTitleColorNight
import com.example.weatherapp.ui.theme.TextTitleColorDay
import com.example.weatherapp.ui.theme.TextTitleColorNight

data class WeatherAppColors(
    val backgroundColor: Brush,
    val iconLocationColor: Color,
    val blur: Color,
    val smallBlur: Color,
    val textColor: Color,
    val textSubTitleColor: Color,
    val cardAboveColor: Color,
    val cardContentAboveColor: Color,
    val cardAboveLineColor: Color,
    val cardContentColor: Color,
    val cardSubContentColor: Color,
    val cardBackgroundColor: Color,
    val cardBackgroundBorderColor: Color,
)

val WeatherAppDayColors = WeatherAppColors(
    backgroundColor = BackgroundColorDay,
    iconLocationColor = IconLocationColorDay,
    blur = BlurColor,
    smallBlur = SmallBlurColor,
    textColor = TextTitleColorDay,
    textSubTitleColor = TextSubTitleColorDay,
    cardAboveColor = CardAboveColorDay,
    cardContentAboveColor = CardContentAboveColorDay,
    cardAboveLineColor = CardAboveLineColorDay,
    cardContentColor = CardContentColorDay,
    cardSubContentColor = CardSubContentColorDay,
    cardBackgroundColor = CardBackgroundColorDay,
    cardBackgroundBorderColor = CardBackgroundBorderColorDay,
)

val WeatherAppDarkColors = WeatherAppColors(
    backgroundColor = BackgroundColorNight,
    iconLocationColor = IconLocationColorNight,
    blur = NightBlurColor,
    smallBlur = NightSmallBlurColor,
    textColor = TextTitleColorNight,
    textSubTitleColor = TextSubTitleColorNight,
    cardAboveColor = CardAboveColorNight,
    cardContentAboveColor = CardContentAboveColorNight,
    cardAboveLineColor = CardContentAboveLineColorNight,
    cardContentColor = CardContentColorNight,
    cardSubContentColor = CardSubContentColorNight,
    cardBackgroundColor = CardBackgroundColorNight,
    cardBackgroundBorderColor = CardBackgroundBorderColorNight,
)
