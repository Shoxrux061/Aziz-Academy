package aziz.academy.presentation.screens.course_details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import aziz.academy.presentation.R
import aziz.academy.presentation.ui.color.BackgroundColor
import aziz.academy.presentation.ui.color.TextPrimary
import aziz.academy.presentation.ui.color.ThemePrimary
import aziz.academy.presentation.ui.color.ThemeSecondary
import aziz.academy.presentation.ui.components.ImagePlaceholder
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Preview(showBackground = true)
@Composable
fun CourseDetailsScreen() {

    val scrollState = rememberScrollState()

    val screenModel: CourseDetailsModel = CourseDetailsModel(
        description = "IT Dasturlash kursi Webga yo'naltirilgan",
        price = "698000,00 so'm",
        name = "IT Dasturlash",
        image = "",
        info = "",
        duration = "13 oy"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(horizontal = 16.dp)
            .verticalScroll(scrollState),
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(220.dp),

            colors = CardDefaults.cardColors(
                containerColor = ThemeSecondary
            )
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(screenModel.image)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                loading = {
                    ImagePlaceholder()
                },
                error = {
                    ImagePlaceholder()
                }
            )
        }

        Text(
            text = screenModel.name,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            color = ThemePrimary
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = screenModel.description,
            color = TextPrimary,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            fontSize = 14.sp,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Kurs davomiyligi: ${screenModel.duration}"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .padding()
                .align(Alignment.End),
            border = BorderStroke(width = 2.dp, color = ThemePrimary),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = ThemeSecondary
            )
        ) {

            Text(
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp),
                text = screenModel.price,
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular))
            )

        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Mavzular",
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            fontSize = 16.sp,
            color = ThemePrimary
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            fontSize = 12.sp,
            lineHeight = 20.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            text = "1-4-haftalar: Python Asoslari 1-hafta: Pythonga kirish, o'zgaruvchilar va ma'lumot turlari 2-hafta: Shartli operatorlar (if, else, elif), tsikllar (for, while) 3-hafta: Funksiyalar va modullar 4-hafta: Ma'lumotlar tuzilmalari: ro'yxatlar, lug'atlar, to'plamlar, tuzilmalar 5-8-haftalar: Python Dasturlashning Asosiy Ko'nikmalari 5-hafta: Fayl tizimi bilan ishlash, faylni o'qish va yozish 6-hafta: Python kutubxonalariga kirish (datetime, os va boshqalar) 7-hafta: Ob'ektga yo'naltirilgan dasturlash (OOP) asoslari 8-hafta: Sinflar va obyektlar: xususiyatlar va metodlar 9-12-haftalar: Ma'lumotlarni yig'ish va Parserlar 9-hafta: Parser nima? Veb sahifalarni skrap qilishga kirish 10-hafta: requests va BeautifulSoup bilan veb-sahifalarni parselash 11-hafta: lxml bilan XML va HTML hujjatlarni tahlil qilish 12-hafta: API'lardan ma'lumot olish: REST API va JSON formatini tushunish 13-16-haftalar: SQL Asoslari va PostgreSQL 13-hafta: SQL kirish va ma'lumotlar bazalari asoslari 14-hafta: SQL buyruqlari: SELECT, INSERT, UPDATE, DELETE 15-hafta: Ma'lumotlar bilan ishlash: bog'langan jadvallar (JOIN) 16-hafta: PostgreSQL ma'lumotlar bazasiga kirish va konfiguratsiya 17-20-haftalar: PostgreSQL va Murakkab SQL Ko'nikmalari 17-hafta: Indekslar va ko'rinishlar (Views) bilan ishlash 18-hafta: Tranzaksiyalar va blokirovkalar 19-hafta: Funksiyalar va triggerlar 20-hafta: PostgreSQL xavfsizlik va foydalanuvchilarni boshqarish 21-24-haftalar: Telegram Bot Yaratish (pyTelegramBotAPI) 21-hafta: Telegram botiga kirish va bot yaratish 22-hafta: pyTelegramBotAPI bilan foydalanuvchilar bilan interaktiv suhbat 23-hafta: Botda inline tugmalar va menyularni yaratish 24-hafta: Foydalanuvchi ma'lumotlarini saqlash (SQLite yoki PostgreSQL bilan integratsiya) 25-28-haftalar: Botni Murakkablashtirish va Telegram API Bilan Ishlash 25-hafta: Telegram botida xabarlarni boshqarish va fayllarni yuborish 26-hafta: Botda admin panelini yaratish 27-hafta: Botga statistikani qo'shish va kuzatish 28-hafta: Foydalanuvchi autentifikatsiyasi va API bilan ishlash 29-32-haftalar: Django Asoslari va Veb-sayt Yaratish 29-hafta: Django Frameworkga kirish, loyiha va ilova yaratish 30-hafta: Django model, view, template tizimi 31-hafta: Ma'lumotlar bazasi bilan ishlash: ORM asoslari 32-hafta: Django admin paneli va foydalanuvchilarni boshqarish 33-36-haftalar: Django Web-saytni Rivojlantirish 33-hafta: Formalar va foydalanuvchi kirish tizimi 34-hafta: Statik fayllar, media fayllar va fayl yuklash 35-hafta: Django signal va custom middleware'lar yaratish 36-hafta: Djangoda xavfsizlik: foydalanuvchi ruxsatlari va autentifikatsiya 37-40-haftalar: Loyihalarni Yakunlash 37-hafta: Django'da REST API yaratish va Django Rest Framework bilan ishlash 38-hafta: Loyihani serverga joylashtirish va ishlab chiqarish muhiti 39-hafta: Django va Telegram botni birlashtirish (API orqali) 40-hafta: Yakuniy loyiha: full-stack dastur yaratish (Telegram bot va veb-sayt integratsiyasi)"
        )
    }
}