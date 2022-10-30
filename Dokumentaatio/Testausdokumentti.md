# Testausdokumentti

## Testikattavuus

Ohjelman testikattavuus:

<img src="https://github.com/Jannepen/Labyrintit/blob/main/Dokumentaatio/Kuvat/Testikattavuus.png">

Paketti Labyrintit sisältää sovelluksen käyttöliittymään liittyvät luokat, joten näitä luokkia ei ole testattu.

## Mitä on testattu?

Testausluokat SatunnainenKruskalTest ja SatunnainenPrimTest sisältävät samantyyppiset testit, jotka testaavat luodun labyrintin oikeellisuutta.

Testit toimivat idealla:

1. Luodaan labyrintti käyttäen testattavaa luokkaa.
2. Käydään labyrintin kaikki reitit läpi käyttämällä syvyyshakua, ja tallennetaan syvyyshaun tulokset taulukkoon.
3. Valitaan labyrintin eri puolilta kaksi solua (esim. solu vasemmassa yläkulmassa ja oikeassa alakulmassa). Tarkistetaan syvyyshaun taulukon avulla onko solujen välillä reitti.

Testien ideana on tarkistaa, että luodut labyrintit ovat yhtenäisiä. Labyrintissa ei tulisi olla solmuja joista ei pääse labyrintin kaikkiin muihin soluihin.

### Kruskal

Kruskal-algoritmilla luotu labyrintti testataan aloittamalla vasemmalla yläkulmassa olevasta solusta. Käytetään syvyyshaulla luotua taulukkoa ja tarkastetaan, että siitä on olemassa reitti oikeassa yläkulmassa, vasemmassa yläkulmassa sekä oikeassa alakulmassa oleviin soluihin.

### Prim

Prim-algoritmilla luodut labyrintit ovat hieman erilaisia kuin Kruskalilla luodut, joten testeissä otetaan koesoluiksi soluja jotka tiedetään olevan labyrintissa. Esimerkiksi testi reittiVasempaanAlakulmaan() ottaa aloitussoluksi toisen rivin ensimmäisen labyrinttiin kuuluvan solun, ja kokeilee että siitä on reitti kolmanneksi alimmalla rivillä olevaan soluun.

## Testien toistaminen

Testit voidaan toistaa menemällä repositorioon jossa ohjelma sijaitsee, ja ajamalla komento
   `./gradlew test`
