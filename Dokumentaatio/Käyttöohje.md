# Käyttöohje

## Ohjelman lataaminen

Kloonaa repositorio omalle koneellesi   
   `git clone https://github.com/Jannepen/Labyrintit.git`
   
   
## Ohjelman suorittaminen

Ohjelman toimivuus testattu linux-käyttöjärjestelmällä. Gradle komento saattaa olla eri toisillä käyttöjärjestelmillä.

1. Mene repositorioon jossa ohjelma sijaitsee. Rakenna projekti
   `./gradlew build`   
   Jar tiedosto löytyy polusta `/build/libs/Labyrintit.jar`

2. Ohjelman ajaminen onnistuu komennolla   
   `./gradlew run`


3. Testit suoritetaan komennolla   
   `./gradlew test`
   
4. Testikattavuusraportti luodaan komennolla   
   `./gradlew test jacocoTestReport`   
   Raportti löytyy polusta `build/reports/jacoco/test/html/index.html`

5. Javadoc luodaan komennolla   
   `./gradlew javadoc`   
   Dokumentti löytyy polusta `build/docs/javadoc/index.html`
   
   
## Tekstikäyttöliittymän käyttäminen

Ohjelma antaa käynnistyessään kolme vaihtoehtoa:

1) Luo labyrintti Primin algoritmilla
2) Luo labyrintti Kruskalin algoritmilla
3) Poistu

### Primin algoritmi

1) Valitse Primin algoritmi kirjoittamalla "1" ja painamalla Enter.
2) Kerro ohjelmalle haluamasi labyrintin koko (esim. 15) ja paina Enter.

Nyt ohjelma tulostaa labyrintin, joka on luotu Primin algoritmia käyttäen, ja palaa alkuvalikkoon.

### Kruskalin algoritmi

1) Valitse Kruskalin algoritmi kirjoittamalla "2" ja painamalla Enter.
2) Kerro ohjelmalle haluamasi labyrintin koko (esim. 15) ja paina Enter.

Nyt ohjelma tulostaa labyrintin, joka on luotu Kruskalin algoritmia käyttäen, ja palaa alkuvalikkoon.

### Poistuminen

Kun haluat poistua ohjelmistosta, kirjoita "3" ja paina Enter.




