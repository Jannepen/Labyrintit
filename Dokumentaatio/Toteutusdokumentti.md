# Toteutusdokumentti

## Ohjelman yleisrakenne

Ohjelma koostuu paketeista Labyrintit, Labyrintit.Kruskal sekä Labyrintit.Prim.

1. Labyrintit sisältää käyttöliittymään liittyvät luokat.
2. Labyrintit.Kruskal sisältää kruskalin algoritmiin käytettävät luokat.
3. Labyrintit.Prim sisältää primin algoritmiin käytettävät luokat.

## Aika- ja tilavaativuudet (pseudokoodista)

Kruskal: O(n + m log n)

Prim: O(n + m log n)

## Puutteita

* Työn testaaminen jäi vähäiseksi, yksittäisiä metodeja ei testattu kunnolla
* Checkstylen avulla koodin laadun tarkasteleminen jäi vähäiseksi.

## Parannusehdotuksia

* Graafisen käyttöliittymän avulla olisi mahdollista animoida labyrintin luominen.
* Suorakulmion muotoisten labyrinttien luominen, tällä hetkellä on mahdollista luoda ainoastaan neliön muotoisia labyrintteja.
* Käyttöliittymän virhekäsittelyn parantaminen, ohjelman saa kaadettua väärillä syötteillä.

## Lähteet

* https://en.wikipedia.org/wiki/Maze_generation_algorithm
* https://en.wikipedia.org/wiki/Kruskal%27s_algorithm
* https://en.wikipedia.org/wiki/Prim%27s_algorithm
* https://www.cs.helsinki.fi/u/ahslaaks/tirakirja/
* https://weblog.jamisbuck.org/2011/1/3/maze-generation-kruskal-s-algorithm
* https://www.youtube.com/watch?v=JptKmWQSerU
* https://www.youtube.com/watch?v=ayW5B2W9hfo
