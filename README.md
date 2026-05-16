# PAMO - Kalkulator BMI i Zapotrzebowania Kalorycznego

**Author:** Krzysztof Cieślik

## Organizacja Repo
Stan dla następnych zajęć jest scalony do main.  
Stan z zajęć przetrzymywany jest na osobnych gałęziach dla wygodny wg numeracji:  
- Zajęcia 1 - PAMO01
- Zajęcia 2 - PAMO02
- itd...

## Funkcjonalności

### Kalkulator BMI
- Obliczanie BMI na podstawie wagi i wzrostu
- Interpretacja wyniku: Niedowaga / W normie / Nadwaga / Otyłość

### Kalkulator Zapotrzebowania Kalorycznego (BMR)
- Obliczanie dziennego zapotrzebowania kalorycznego metodą Harrisa-Benedicta
- Uwzględnia płeć, wiek i poziom aktywności fizycznej (5 poziomów)

### Historia BMI
- Wykres liniowy zmian BMI w czasie (dane mockowane)
- Zrealizowany przy użyciu biblioteki MPAndroidChart

### Lista zakupów
- Lista produktów zdrowej diety z możliwością odznaczania zakupionych pozycji
- Stan checkboxów zapisywany trwale przy użyciu SharedPreferences

## Zrzuty ekranu

| Kalkulator | Lista zakupów (Monkey)|
|---|---|
| ![Kalkulator](app/HealtHCalculatorScreenshot.avif) | ![Lista zakupów](monkey_result.avif) |

## Testy

### Testy jednostkowe (JUnit)
Uruchomienie:
```bash
./gradlew test
```
- `BmiCalculatorTest` — testy obliczania BMI i interpretacji wyniku
- `ShoppingItemTest` — testy modelu danych listy zakupów

### Testy UI (Espresso)
Wymagają podłączonego urządzenia lub emulatora:
```bash
./gradlew connectedAndroidTest
```
- `CalculatorUITest` — testy przepływu obliczania BMI i BMR

### Testy stabilności (Monkey)
Wymagają zainstalowanej aplikacji i narzędzia [just](https://github.com/casey/just):
```bash
just monkey              # 500 losowych zdarzeń
just monkey-screenshot   # monkey + zrzut ekranu
```

## Licencja (MIT License)

Copyright (c) 2026 Krzysztof Cieślik

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
