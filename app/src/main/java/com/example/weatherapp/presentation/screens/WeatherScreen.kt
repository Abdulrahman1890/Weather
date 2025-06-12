package com.example.weatherapp.presentation.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.composable.CurrentWeatherCard
import com.example.weatherapp.presentation.composable.HourlyWeatherChip
import com.example.weatherapp.presentation.composable.WeeklyWeatherCard
import com.example.weatherapp.presentation.model.CardWeatherData
import com.example.weatherapp.presentation.viewModel.WeatherViewModel
import com.example.weatherapp.ui.theme.Urbanist

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherScreen(
    weatherViewModel: WeatherViewModel
) {
    val state = weatherViewModel.state.collectAsState().value

    if (state.isLoading) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.LightGray)
        )
    } else if (state.error != null) {
        Text(text = "Error", color = Color.Red)
    } else {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    state.weatherColor.backgroundColor
                )
                .systemBarsPadding()
                .navigationBarsPadding()
                .verticalScroll(scrollState)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_location),
                    contentDescription = null,
                    tint = state.weatherColor.iconLocationColor
                )
                Spacer(Modifier.width(10.dp))
                state.weatherData?.let {
                    Text(
                        text = it.city,
                        color = state.weatherColor.textColor,
                        fontFamily = Urbanist,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 0.25.sp,
                    )
                }
            }

            CurrentWeatherCard(
                state,
                scrollState = scrollState,
            )

            Spacer(Modifier.height(24.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                userScrollEnabled = false,
                verticalArrangement = Arrangement.spacedBy(6.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier
                    .heightIn(max = 250.dp)
                    .padding(horizontal = 12.dp)
            ) {

                val cardData = listOf(
                    CardWeatherData(
                        image = R.drawable.wind,
                        value = "${state.weatherData?.windSpeed?.toInt() ?: 0} KM/h",
                        title = "Wind"
                    ),
                    CardWeatherData(
                        image = R.drawable.humidity,
                        value = "${state.weatherData?.humidity?.toInt() ?: 0}%",
                        title = "Humidity"
                    ),
                    CardWeatherData(
                        image = R.drawable.rain,
                        value = "${state.weatherData?.rainChance?.toInt() ?: 0}%",
                        title = "Rain"
                    ),
                    CardWeatherData(
                        image = R.drawable.uv,
                        value = "${state.weatherData?.uvIndex?.toInt() ?: 0}",
                        title = "UV Index"
                    ),
                    CardWeatherData(
                        image = R.drawable.pressure,
                        value = "${state.weatherData?.pressure?.toInt() ?: 0} hPa",
                        title = "Pressure"
                    ),
                    CardWeatherData(
                        image = R.drawable.feels_like,
                        value = "${state.weatherData?.feelsLike?.toInt() ?: 0}°C",
                        title = "Feels like"
                    ),
                )

                items(6) { index ->
                    Box(
                        modifier = Modifier
                            .width(108.dp)
                            .height(115.dp)
                            .clip(shape = RoundedCornerShape(24.dp))
                            .border(
                                width = 1.dp,
                                shape = RoundedCornerShape(24.dp),
                                color = state.weatherColor.cardBackgroundBorderColor
                            )
                            .background(state.weatherColor.cardBackgroundColor)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(cardData[index].image),
                                contentDescription = null,
                                tint = Color(0xFF87CEFA),
                                modifier = Modifier.size(32.dp)
                            )
                            Text(
                                text = cardData[index].value,
                                color = state.weatherColor.cardContentColor,
                                fontFamily = Urbanist,
                                fontWeight = FontWeight.Medium,
                                fontSize = 20.sp,
                                letterSpacing = 0.25.sp,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                            Text(
                                text = cardData[index].title,
                                color = state.weatherColor.cardSubContentColor,
                                fontFamily = Urbanist,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                letterSpacing = 0.25.sp,
                                modifier = Modifier.padding(top = 2.dp)
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(24.dp))

            Column {
                Text(
                    text = "Today",
                    color = state.weatherColor.textColor,
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    letterSpacing = 0.25.sp,
                    modifier = Modifier.padding(start = 12.dp)
                )

                Spacer(Modifier.height(12.dp))

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    itemsIndexed(state.weatherData!!.hourlyForecast) { index, item ->
                        HourlyWeatherChip(
                            currentWeather = state, forecastDataItem = item
                        )
                    }
                }
            }

            Spacer(Modifier.height(24.dp))

            Column(
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Text(
                    text = "Next 7 days",
                    color = state.weatherColor.textColor,
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    letterSpacing = 0.25.sp,
                    modifier = Modifier.padding(start = 12.dp)
                )

                Spacer(Modifier.height(12.dp))

                WeeklyWeatherCard(
                    modifier = Modifier.padding(horizontal = 12.dp), currentWeather = state
                )
            }
        }
    }
}