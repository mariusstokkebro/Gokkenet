# Gokkenet
Beskrivelse af databaseforløb
Med Mærius, Christian og Casper.

Hashing
En hash-algoritme er en funktion, der konverterer en datastreng til en numerisk strengoutput med fast længde. 
Outputstrengen er generelt meget mindre end de originale data. Hash-algoritmer er designet til at være kollisionsresistente, 
hvilket betyder, at der er meget lav sandsynlighed for, at den samme streng oprettes til forskellige data. 
To af de mest almindelige hashalgoritmer er MD5 (Message-Digest algoritme 5) og SHA-1 (Secure Hash Algorithm). 
MD5 Message Digest-kontrolsum bruges ofte til at validere dataintegritet, når digitale filer overføres eller gemmes.

Vi brugte Hashing til hvores password så når folk kigger dirkte i databsen ville de ikke kunne se hvad brugerne password er da det er outputtet af functione. så du skal have kode ordet for at kunne logge ind


Forløbet
Nu når vi har beskrevet hvordan hashing fungerer skal vi beskrive vores forløb med databaser. Forløbet bestod af at vi skulle lave et af tre produkter der omhandlede databaser. 
Vi valgte det første ud af de tre, og det gik ud på at vi skulle lave et chatprogram, hvor to brugere kunne tale sammen.
Disse to brugere skulle have et login der bestod af et Id, brugernavn og password.
Processen gik som at vi først skulle lave databasen. Vi ville gerne sætte to accounts op, så vi lavede et account til Casper og en abe der hedder Albert. Casper er dårlig til at lave passwords, så hans password blev Cas123. Albert er en abe der ikke kan benytte sig af teknologi, men hans dyrepassere er heller ikke særligt gode til det med cybersikkerhed, så hans password blev bare Abe123. De fik også ID’er 1 og 2. 
Vi lavede nu en login feature, så man kunne skrive en kombination af et brugernavn og et password der overensstemte med et entry i databasen, lukkede programmet. Vi havde ikke resten af chatprogrammet, så det var den bedste funktion vi kunne finde på. Vi arbejdede nu også på at man kunne registrere kontoer til databasen, og give dem et unikt ID, og lavede selve chatprogrammet.

de forskellige bruger:


Brugernavn:Casper
Kodeord:Cas123

Brugernavn:Albert
Kodeord:Abe123

Brugernavn:Marius
Kodeord:Sex6
