/**
 * @author Allyson
 * @since 17/12/2024
 */
package org.openjfx.test9.model;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openjfx.test9.services.SeralizationControler;

public class GenreList {
	/**
	 * music genres list as a String
	 */
	private final static  String baseList ="Alternative\r\n"
            + "Art Punk\r\n"
            + "Alternative Rock\r\n"
            + "Britpunk\r\n"
            + "College Rock\r\n"
            + "Crossover Thrash\r\n"
            + "Crust Punk (thx Haug)\r\n"
            + "Emotional Hardcore (emo / emocore)\r\n"
            + "Experimental Rock\r\n"
            + "Folk Punk\r\n"
            + "Goth / Gothic Rock\r\n"
            + "Grunge\r\n"
            + "Hardcore Punk\r\n"
            + "Hard Rock\r\n"
            + "Indie Rock\r\n"
            + "Lo-fi\r\n"
            + "Musique Concrète\r\n"
            + "New Wave\r\n"
            + "Progressive Rock\r\n"
            + "Punk\r\n"
            + "Shoegaze\r\n"
            + "Steampunk\r\n"
            + "Anime\r\n"
            + "Blues\r\n"
            + "Acoustic Blues\r\n"
            + "African Blues\r\n"
            + "Blues Rock\r\n"
            + "Blues Shouter\r\n"
            + "British Blues\r\n"
            + "Canadian Blues\r\n"
            + "Chicago Blues\r\n"
            + "Classic Blues\r\n"
            + "Classic Female Blues\r\n"
            + "Contemporary Blues\r\n"
            + "Contemporary R&B\r\n"
            + "Country Blues\r\n"
            + "Dark Blues\r\n"
            + "Delta Blues\r\n"
            + "Detroit Blues\r\n"
            + "Doom Blues\r\n"
            + "Electric Blues\r\n"
            + "Folk Blues\r\n"
            + "Gospel Blues\r\n"
            + "Harmonica Blues\r\n"
            + "Hill Country Blues\r\n"
            + "Hokum Blues\r\n"
            + "Jazz Blues\r\n"
            + "Jump Blues\r\n"
            + "Kansas City Blues\r\n"
            + "Louisiana Blues\r\n"
            + "Memphis Blues\r\n"
            + "Modern Blues\r\n"
            + "New Orlean Blues\r\n"
            + "NY Blues\r\n"
            + "Piano Blues\r\n"
            + "Piedmont Blues\r\n"
            + "Punk Blues\r\n"
            + "Ragtime Blues\r\n"
            + "Rhythm Blues\r\n"
            + "Soul Blues\r\n"
            + "St. Louis Blues\r\n"
            + "Soul Blues\r\n"
            + "Swamp Blues\r\n"
            + "Texas Blues\r\n"
            + "Urban Blues\r\n"
            + "Vandeville\r\n"
            + "West Coast Blues\r\n"
            + "Zydeco (also under ‘World’ genre)\r\n"
            + "Children’s Music\r\n"
            + "Lullabies\r\n"
            + "Sing-Along\r\n"
            + "Stories\r\n"
            + "Classical\r\n"
            + "Avant-Garde\r\n"
            + "Ballet\r\n"
            + "Baroque\r\n"
            + "Cantata\r\n"
            + "Chamber Music\r\n"
            + "String Quartet\r\n"
            + "Chant\r\n"
            + "Choral\r\n"
            + "Classical Crossover\r\n"
            + "Concerto\r\n"
            + "Concerto Grosso\r\n"
            + "Contemporary Classical\r\n"
            + "Early Music\r\n"
            + "Expressionist\r\n"
            + "High Classical\r\n"
            + "Impressionist\r\n"
            + "Mass Requiem\r\n"
            + "Medieval\r\n"
            + "Minimalism\r\n"
            + "Modern Composition\r\n"
            + "Modern Classical\r\n"
            + "Opera\r\n"
            + "Oratorio\r\n"
            + "Orchestral\r\n"
            + "Organum\r\n"
            + "Renaissance\r\n"
            + "Romantic (early period)\r\n"
            + "Romantic (later period)\r\n"
            + "Sonata\r\n"
            + "Symphonic\r\n"
            + "Symphony\r\n"
            + "Twelve-tone\r\n"
            + "Wedding Music\r\n"
            + "Comedy\r\n"
            + "Novelty\r\n"
            + "Parody Music (Weird Al!)\r\n"
            + "Stand-up Comedy\r\n"
            + "Vaudeville\r\n"
            + "Commercial\r\n"
            + "Jingles\r\n"
            + "TV Themes\r\n"
            + "Country\r\n"
            + "Alternative Country\r\n"
            + "Americana\r\n"
            + "Australian Country\r\n"
            + "Bakersfield Sound\r\n"
            + "Bluegrass\r\n"
            + "Progressive Bluegrass\r\n"
            + "Reactionary Bluegrass\r\n"
            + "Blues Country\r\n"
            + "Cajun Fiddle Tunes\r\n"
            + "Christian Country\r\n"
            + "Classic Country\r\n"
            + "Close Harmony\r\n"
            + "Contemporary Bluegrass\r\n"
            + "Contemporary Country\r\n"
            + "Country Gospel\r\n"
            + "Country Pop\r\n"
            + "Country Rap\r\n"
            + "Country Rock\r\n"
            + "Country Soul\r\n"
            + "Cowboy / Western\r\n"
            + "Cowpunk\r\n"
            + "Dansband\r\n"
            + "Honky Tonk\r\n"
            + "Franco-Country\r\n"
            + "Gulf and Western\r\n"
            + "Hellbilly Music\r\n"
            + "Honky Tonk\r\n"
            + "Instrumental Country\r\n"
            + "Lubbock Sound\r\n"
            + "Nashville Sound\r\n"
            + "Neotraditional Country\r\n"
            + "Outlaw Country\r\n"
            + "Progressive\r\n"
            + "Psychobilly / Punkabilly\r\n"
            + "Red Dirt\r\n"
            + "Sertanejo\r\n"
            + "Texas County\r\n"
            + "Traditional Bluegrass\r\n"
            + "Traditional Country\r\n"
            + "Truck-Driving Country\r\n"
            + "Urban Cowboy\r\n"
            + "Western Swing\r\n"
            + "Zydeco\r\n"
            + "Dance (EDM – Electronic Dance Music – see Electronic below)\r\n"
            + "Club / Club Dance\r\n"
            + "Breakcore\r\n"
            + "Breakbeat / Breakstep\r\n"
            + "4-Beat\r\n"
            + "Acid Breaks\r\n"
            + "Baltimore Club\r\n"
            + "Big Beat\r\n"
            + "Breakbeat Hardcore\r\n"
            + "Broken Beat\r\n"
            + "Florida Breaks\r\n"
            + "Nu Skool Breaks\r\n"
            + "Brostep\r\n"
            + "Chillstep\r\n"
            + "Deep House\r\n"
            + "Dubstep\r\n"
            + "Electro House\r\n"
            + "Electroswing\r\n"
            + "Exercise\r\n"
            + "Future Garage\r\n"
            + "Garage\r\n"
            + "Glitch Hop\r\n"
            + "Glitch Pop\r\n"
            + "Grime\r\n"
            + "Hardcore\r\n"
            + "Bouncy House\r\n"
            + "Bouncy Techno\r\n"
            + "Breakcore\r\n"
            + "Digital Hardcore\r\n"
            + "Doomcore\r\n"
            + "Dubstyle\r\n"
            + "Gabber\r\n"
            + "Happy Hardcore\r\n"
            + "Hardstyle\r\n"
            + "Jumpstyle\r\n"
            + "Makina\r\n"
            + "Speedcore\r\n"
            + "Terrorcore\r\n"
            + "Uk Hardcore\r\n"
            + "\r\n"
            + "\r\n"
            + "\r\n"
            + "\r\n"
            + "\r\n"
            + "Hard Dance\r\n"
            + "Hi-NRG / Eurodance\r\n"
            + "Horrorcore (thx Matt)\r\n"
            + "House\r\n"
            + "Acid House\r\n"
            + "Chicago House\r\n"
            + "Deep House\r\n"
            + "Diva House\r\n"
            + "Dutch House\r\n"
            + "Electro House\r\n"
            + "Freestyle House\r\n"
            + "French House\r\n"
            + "Funky House\r\n"
            + "Ghetto House\r\n"
            + "Hardbag\r\n"
            + "Hip House\r\n"
            + "Italo House\r\n"
            + "Latin House\r\n"
            + "Minimal House\r\n"
            + "Progressive House\r\n"
            + "Rave Music\r\n"
            + "Swing House\r\n"
            + "Tech House\r\n"
            + "Tribal House\r\n"
            + "Tropical House\r\n"
            + "UK Hard House\r\n"
            + "US Garage\r\n"
            + "Vocal House\r\n"
            + "Jackin House\r\n"
            + "Jungle / Drum’n’bass\r\n"
            + "Liquid Dub\r\n"
            + "Regstep\r\n"
            + "Speedcore\r\n"
            + "Techno\r\n"
            + "Acid Techno\r\n"
            + "Detroit Techno\r\n"
            + "Free Tekno\r\n"
            + "Ghettotech\r\n"
            + "Minimal\r\n"
            + "Nortec\r\n"
            + "Schranz\r\n"
            + "Techno-Dnb\r\n"
            + "Technopop\r\n"
            + "Tecno Brega\r\n"
            + "Toytown Techno\r\n"
            + "Trance\r\n"
            + "Acid Trance\r\n"
            + "Acid-House\r\n"
            + "Classic Trance\r\n"
            + "Dark Psy\r\n"
            + "Deep House\r\n"
            + "Dream Trance\r\n"
            + "Goa Trance\r\n"
            + "Dark Psytrance\r\n"
            + "Full on\r\n"
            + "Psybreaks\r\n"
            + "Psyprog\r\n"
            + "Suomisaundi\r\n"
            + "Hard Trance\r\n"
            + "Prog. Trance\r\n"
            + "Psy-Trance\r\n"
            + "Minimal Techno\r\n"
            + "Tech House\r\n"
            + "Tech Trance\r\n"
            + "Uplifting Trance\r\n"
            + "Orchestral Uplifting\r\n"
            + "Vocal Trance\r\n"
            + "Trap\r\n"
            + "Disney\r\n"
            + "Easy Listening\r\n"
            + "Background\r\n"
            + "Bop\r\n"
            + "Elevator\r\n"
            + "Furniture\r\n"
            + "Lounge\r\n"
            + "Middle of the Road\r\n"
            + "Swing\r\n"
            + "Electronic\r\n"
            + "2-Step (thx Ran’dom Haug)\r\n"
            + "8bit – aka 8-bit, Bitpop and Chiptune (see below)\r\n"
            + "Ambient\r\n"
            + "Ambient Dub\r\n"
            + "Ambient House\r\n"
            + "Ambient Techno\r\n"
            + "Dark Ambient\r\n"
            + "Drone Music\r\n"
            + "Illbient\r\n"
            + "Isolationism\r\n"
            + "Lowercase\r\n"
            + "Asian Underground\r\n"
            + "Bassline\r\n"
            + "Chillwave\r\n"
            + "Chiptune\r\n"
            + "Bitpop\r\n"
            + "Game Boy\r\n"
            + "Nintendocore\r\n"
            + "Video Game Music\r\n"
            + "Yorkshire Bleeps and Bass\r\n"
            + "Crunk\r\n"
            + "Downtempo\r\n"
            + "Acid Jazz\r\n"
            + "Balearic Beat\r\n"
            + "Chill Out\r\n"
            + "Dub Music\r\n"
            + "Dubtronica\r\n"
            + "Ethnic Electronica\r\n"
            + "Moombahton\r\n"
            + "Nu Jazz\r\n"
            + "Trip Hop\r\n"
            + "Drum & Bass\r\n"
            + "Darkcore\r\n"
            + "Darkstep\r\n"
            + "Drumfunk\r\n"
            + "Drumstep\r\n"
            + "Hardstep\r\n"
            + "Intelligent Drum and Bass\r\n"
            + "Jump-Up\r\n"
            + "Liquid Funk\r\n"
            + "Neurofunk\r\n"
            + "Oldschool Jungle:\r\n"
            + "Darkside Jungle\r\n"
            + "Ragga Jungle\r\n"
            + "Raggacore\r\n"
            + "Sambass\r\n"
            + "Techstep\r\n"
            + "Electro\r\n"
            + "Crunk\r\n"
            + "Electro Backbeat\r\n"
            + "Electro-Grime\r\n"
            + "Electropop\r\n"
            + "Electro-swing\r\n"
            + "Electroacoustic\r\n"
            + "Acousmatic Music\r\n"
            + "Computer Music\r\n"
            + "Electroacoustic Improvisation\r\n"
            + "Field Recording\r\n"
            + "Live Coding\r\n"
            + "Live Electronics\r\n"
            + "Soundscape Composition\r\n"
            + "Tape Music\r\n"
            + "Electronica\r\n"
            + "Berlin School\r\n"
            + "Chillwave\r\n"
            + "Electronic Art Music\r\n"
            + "Electronic Dance Music\r\n"
            + "Folktronica\r\n"
            + "Freestyle Music\r\n"
            + "Glitch\r\n"
            + "Idm\r\n"
            + "Laptronica\r\n"
            + "Skweee\r\n"
            + "Sound Art\r\n"
            + "Synthcore\r\n"
            + "Electronic Rock\r\n"
            + "Alternative Dance\r\n"
            + "Baggy\r\n"
            + "Madchester\r\n"
            + "Dance-Punk\r\n"
            + "Dance-Rock\r\n"
            + "Dark Wave\r\n"
            + "Electroclash\r\n"
            + "Electronicore\r\n"
            + "Electropunk\r\n"
            + "Ethereal Wave\r\n"
            + "Indietronica\r\n"
            + "New Rave\r\n"
            + "Space Rock\r\n"
            + "Synthpop\r\n"
            + "Synthpunk\r\n"
            + "Eurodance\r\n"
            + "Bubblegum Dance\r\n"
            + "Italo Dance\r\n"
            + "Turbofolk\r\n"
            + "Hardstyle\r\n"
            + "Hi-Nrg\r\n"
            + "Eurobeat\r\n"
            + "Hard Nrg\r\n"
            + "New Beat\r\n"
            + "IDM/Experimental\r\n"
            + "Industrial\r\n"
            + "Trip Hop\r\n"
            + "Vaporwave\r\n"
            + "Hyponagogic\r\n"
            + "Vektroid\r\n"
            + "Mallsoft\r\n"
            + "Vaportrap\r\n"
            + "Vaporhop\r\n"
            + "Protovapor\r\n"
            + "UK Garage\r\n"
            + "2-Step\r\n"
            + "4×4\r\n"
            + "Bassline\r\n"
            + "Grime\r\n"
            + "Speed Garage\r\n"
            + "Enka\r\n"
            + "French Pop\r\n"
            + "Folk Music (also under various other categories)\r\n"
            + "American Folk Revival\r\n"
            + "Anti-Folk\r\n"
            + "British Folk Revival\r\n"
            + "Contemporary Folk\r\n"
            + "Filk Music\r\n"
            + "Freak Folk\r\n"
            + "Indie Folk\r\n"
            + "Industrial Folk\r\n"
            + "Neofolk\r\n"
            + "Progressive Folk\r\n"
            + "Psychedelic Folk\r\n"
            + "Sung Poetry\r\n"
            + "Techno-Folk\r\n"
            + "German Folk\r\n"
            + "German Pop\r\n"
            + "Fitness & Workout\r\n"
            + "Hip-Hop/Rap\r\n"
            + "Alternative Rap\r\n"
            + "Avant-Garde\r\n"
            + "Bounce\r\n"
            + "Chap Hop\r\n"
            + "Christian Hip Hop\r\n"
            + "Conscious Hip Hop\r\n"
            + "Country-Rap\r\n"
            + "Grunk\r\n"
            + "Crunkcore\r\n"
            + "Cumbia Rap\r\n"
            + "Dirty South\r\n"
            + "East Coast\r\n"
            + "Brick City Club\r\n"
            + "Hardcore Hip Hop\r\n"
            + "Mafioso Rap\r\n"
            + "New Jersey Hip Hop\r\n"
            + "Freestyle Rap\r\n"
            + "G-Funk\r\n"
            + "Gangsta Rap\r\n"
            + "Golden Age\r\n"
            + "Grime\r\n"
            + "Hardcore Rap\r\n"
            + "Hip-Hop\r\n"
            + "Hip Pop\r\n"
            + "Horrorcore\r\n"
            + "Hyphy\r\n"
            + "Industrial Hip Hop\r\n"
            + "Instrumental Hip Hop\r\n"
            + "Jazz Rap\r\n"
            + "Latin Rap\r\n"
            + "Low Bap\r\n"
            + "Lyrical Hip Hop\r\n"
            + "Merenrap\r\n"
            + "Midwest Hip Hop\r\n"
            + "Chicago Hip Hop\r\n"
            + "Detroit Hip Hop\r\n"
            + "Horrorcore\r\n"
            + "St. Louis Hip Hop\r\n"
            + "Twin Cities Hip Hop\r\n"
            + "Motswako\r\n"
            + "Nerdcore\r\n"
            + "New Jack Swing\r\n"
            + "New School Hip Hop\r\n"
            + "Old School Rap\r\n"
            + "Rap\r\n"
            + "Trap\r\n"
            + "Turntablism\r\n"
            + "Underground Rap\r\n"
            + "West Coast Rap\r\n"
            + "Holiday\r\n"
            + "Chanukah\r\n"
            + "Christmas\r\n"
            + "Christmas: Children’s\r\n"
            + "Christmas: Classic\r\n"
            + "Christmas: Classical\r\n"
            + "Christmas: Comedy\r\n"
            + "Christmas: Jazz\r\n"
            + "Christmas: Modern\r\n"
            + "Christmas: Pop\r\n"
            + "Christmas: R&B\r\n"
            + "Christmas: Religious\r\n"
            + "Christmas: Rock\r\n"
            + "Easter\r\n"
            + "Halloween\r\n"
            + "Holiday: Other\r\n"
            + "Thanksgiving\r\n"
            + "Indie Pop\r\n"
            + "Industrial\r\n"
            + "Aggrotech\r\n"
            + "Coldwave\r\n"
            + "Cybergrind\r\n"
            + "Dark Electro\r\n"
            + "Death Industrial\r\n"
            + "Electro-Industrial\r\n"
            + "Electronic Body Music\r\n"
            + "Futurepop\r\n"
            + "Industrial Metal\r\n"
            + "Neue Deutsche Härte\r\n"
            + "Industrial Rock\r\n"
            + "Noise\r\n"
            + "Japanoise\r\n"
            + "Power Electronics\r\n"
            + "Power Noise\r\n"
            + "Witch House\r\n"
            + "Inspirational – Christian & Gospel\r\n"
            + "CCM\r\n"
            + "Christian Metal\r\n"
            + "Christian Pop\r\n"
            + "Christian Rap\r\n"
            + "Christian Rock\r\n"
            + "Classic Christian\r\n"
            + "Contemporary Gospel\r\n"
            + "Gospel\r\n"
            + "Christian & Gospel\r\n"
            + "Praise & Worship\r\n"
            + "Qawwali\r\n"
            + "Southern Gospel\r\n"
            + "Traditional Gospel\r\n"
            + "Instrumental\r\n"
            + "March (Marching Band)\r\n"
            + "J-Pop (also under ‘Asian’)\r\n"
            + "J-Rock\r\n"
            + "J-Synth\r\n"
            + "J-Ska\r\n"
            + "J-Punk\r\n"
            + "Jazz\r\n"
            + "Acid Jazz\r\n"
            + "Afro-Cuban Jazz\r\n"
            + "Avant-Garde Jazz\r\n"
            + "Bebop\r\n"
            + "Big Band\r\n"
            + "Blue Note\r\n"
            + "British Dance Band (Jazz)\r\n"
            + "Cape Jazz\r\n"
            + "Chamber Jazz\r\n"
            + "Contemporary Jazz\r\n"
            + "Continental Jazz\r\n"
            + "Cool Jazz\r\n"
            + "Crossover Jazz\r\n"
            + "Dark Jazz\r\n"
            + "Dixieland\r\n"
            + "Early Jazz\r\n"
            + "Electro Swing (Jazz)\r\n"
            + "Ethio-jazz\r\n"
            + "Ethno-Jazz\r\n"
            + "European Free Jazz\r\n"
            + "Free Funk (Avant-Garde / Funk Jazz)\r\n"
            + "Free Jazz\r\n"
            + "Fusion\r\n"
            + "Gypsy Jazz\r\n"
            + "Hard Bop\r\n"
            + "Indo Jazz\r\n"
            + "Jazz Blues\r\n"
            + "Jazz-Funk (see Free Funk)\r\n"
            + "Jazz-Fusion\r\n"
            + "Jazz Rap\r\n"
            + "Jazz Rock\r\n"
            + "Kansas City Jazz\r\n"
            + "Latin Jazz\r\n"
            + "M-Base Jazz\r\n"
            + "Mainstream Jazz\r\n"
            + "Modal Jazz\r\n"
            + "Neo-Bop\r\n"
            + "Neo-Swing\r\n"
            + "Nu Jazz\r\n"
            + "Orchestral Jazz\r\n"
            + "Post-Bop\r\n"
            + "Punk Jazz\r\n"
            + "Ragtime\r\n"
            + "Ska Jazz\r\n"
            + "Skiffle (also Folk)\r\n"
            + "Smooth Jazz\r\n"
            + "Soul Jazz\r\n"
            + "Swing Jazz\r\n"
            + "Straight-Ahead Jazz\r\n"
            + "Trad Jazz\r\n"
            + "Third Stream\r\n"
            + "Jazz-Funk\r\n"
            + "Free Jazz\r\n"
            + "West Coast Jazz\r\n"
            + "K-Pop (also under ‘Asian’)\r\n"
            + "Karaoke\r\n"
            + "Kayokyoku\r\n"
            + "Latin\r\n"
            + "Alternativo & Rock Latino\r\n"
            + "Argentine Tango\r\n"
            + "Bachata\r\n"
            + "Baithak Gana\r\n"
            + "Baladas y Boleros\r\n"
            + "Bolero\r\n"
            + "Bossa Nova\r\n"
            + "Brazilian\r\n"
            + "Axé\r\n"
            + "Bossa Nova\r\n"
            + "Brazilian Rock\r\n"
            + "Brega\r\n"
            + "Choro\r\n"
            + "Forró\r\n"
            + "Frevo\r\n"
            + "Funk Carioca\r\n"
            + "Lambada\r\n"
            + "Maracatu\r\n"
            + "Música Popular Brasileira\r\n"
            + "Música Sertaneja\r\n"
            + "Pagode\r\n"
            + "Samba\r\n"
            + "Samba Rock\r\n"
            + "Tecnobrega\r\n"
            + "Tropicalia\r\n"
            + "Zouk-Lambada\r\n"
            + "Chicha\r\n"
            + "Criolla\r\n"
            + "Contemporary Latin\r\n"
            + "Cumbia\r\n"
            + "Flamenco / Spanish Flamenco\r\n"
            + "Huayno\r\n"
            + "Joropo (popular style in Venezuela, and also in the llanos (plains) of Colombia)\r\n"
            + "Latin Jazz\r\n"
            + "Mambo (Cuba)\r\n"
            + "Mariachi\r\n"
            + "Merengue Típico\r\n"
            + "Nuevo Flamenco\r\n"
            + "Pop Latino\r\n"
            + "Portuguese Fado\r\n"
            + "Punta\r\n"
            + "Punta Rock\r\n"
            + "Ranchera\r\n"
            + "Raíces\r\n"
            + "Raison\r\n"
            + "Reggaeton y Hip-Hop\r\n"
            + "Regional Mexicano\r\n"
            + "Salsa y Tropical\r\n"
            + "Soca\r\n"
            + "Son\r\n"
            + "Tejano\r\n"
            + "Timba\r\n"
            + "Twoubadou\r\n"
            + "Vallenato\r\n"
            + "Zouk\r\n"
            + "Metal\r\n"
            + "Heavy Metal\r\n"
            + "Speed Metal\r\n"
            + "Thrash Metal\r\n"
            + "Power Metal\r\n"
            + "Death Metal\r\n"
            + "Black Metal\r\n"
            + "Pagan Metal\r\n"
            + "Viking Metal\r\n"
            + "Folk Metal\r\n"
            + "Symphonic Metal\r\n"
            + "Gothic Metal\r\n"
            + "Glam Metal\r\n"
            + "Hair Metal\r\n"
            + "Doom Metal\r\n"
            + "Groove Metal\r\n"
            + "Industrial Metal\r\n"
            + "Modern Metal\r\n"
            + "Neoclassical Metal\r\n"
            + "New Wave Of British Heavy Metal\r\n"
            + "Post Metal\r\n"
            + "Progressive Metal\r\n"
            + "Avantgarde Metal\r\n"
            + "Sludge\r\n"
            + "Djent\r\n"
            + "Drone\r\n"
            + "Kawaii Metal\r\n"
            + "Pirate Metal\r\n"
            + "Nu Metal\r\n"
            + "Neue Deutsche Härte\r\n"
            + "Math Metal\r\n"
            + "Crossover\r\n"
            + "Grindcore\r\n"
            + "Hardcore\r\n"
            + "Metalcore\r\n"
            + "Deathcore\r\n"
            + "Post Hardcore\r\n"
            + "Mathcore\r\n"
            + "New Age\r\n"
            + "Environmental\r\n"
            + "Healing\r\n"
            + "Meditation\r\n"
            + "Nature\r\n"
            + "Relaxation\r\n"
            + "Travel\r\n"
            + "Opera\r\n"
            + "Pop\r\n"
            + "Adult Contemporary\r\n"
            + "Arab Pop\r\n"
            + "Baroque\r\n"
            + "Britpop\r\n"
            + "Bubblegum Pop\r\n"
            + "Chamber Pop\r\n"
            + "Chanson\r\n"
            + "Christian Pop\r\n"
            + "Classical Crossover\r\n"
            + "Europop\r\n"
            + "Austropop\r\n"
            + "Balkan Pop\r\n"
            + "French Pop\r\n"
            + "Latin Pop\r\n"
            + "Laïkó\r\n"
            + "Nederpop\r\n"
            + "Russian Pop\r\n"
            + "Dance Pop\r\n"
            + "Dream Pop\r\n"
            + "Electro Pop\r\n"
            + "Iranian Pop\r\n"
            + "Jangle Pop\r\n"
            + "Latin Ballad\r\n"
            + "Levenslied\r\n"
            + "Louisiana Swamp Pop\r\n"
            + "Mexican Pop\r\n"
            + "Motorpop\r\n"
            + "New Romanticism\r\n"
            + "Orchestral Pop\r\n"
            + "Pop Rap\r\n"
            + "Popera\r\n"
            + "Pop/Rock\r\n"
            + "Pop Punk\r\n"
            + "Power Pop\r\n"
            + "Psychedelic Pop\r\n"
            + "Schlager\r\n"
            + "Soft Rock\r\n"
            + "Sophisti-Pop\r\n"
            + "Space Age Pop\r\n"
            + "Sunshine Pop\r\n"
            + "Surf Pop\r\n"
            + "Synthpop\r\n"
            + "Teen Pop\r\n"
            + "Traditional Pop Music\r\n"
            + "Turkish Pop\r\n"
            + "Vispop\r\n"
            + "Wonky Pop\r\n"
            + "Post-Disco\r\n"
            + "Boogie\r\n"
            + "Dance-pop\r\n"
            + "Progressive\r\n"
            + "Progressive House / Trance\r\n"
            + "Disco House\r\n"
            + "Dream House\r\n"
            + "Space House\r\n"
            + "Japanese House\r\n"
            + "Bounce / Scouse House\r\n"
            + "Progressive Breaks\r\n"
            + "Progressive Drum & Bass\r\n"
            + "Progressive Techno\r\n"
            + "R&B/Soul\r\n"
            + "(Carolina) Beach Music\r\n"
            + "Contemporary R&B\r\n"
            + "Disco\r\n"
            + "Doo Wop\r\n"
            + "Funk\r\n"
            + "Modern Soul\r\n"
            + "Motown\r\n"
            + "Neo-Soul\r\n"
            + "Northern Soul\r\n"
            + "Psychedelic Soul\r\n"
            + "Quiet Storm\r\n"
            + "Soul\r\n"
            + "Soul Blues\r\n"
            + "Southern Soul\r\n"
            + "Reggae\r\n"
            + "2-Tone\r\n"
            + "Dub\r\n"
            + "Roots Reggae\r\n"
            + "Reggae Fusion\r\n"
            + "Reggae en Español\r\n"
            + "Spanish Reggae\r\n"
            + "Reggae 110\r\n"
            + "Reggae Bultrón\r\n"
            + "Romantic Flow\r\n"
            + "Lovers Rock\r\n"
            + "Raggamuffin\r\n"
            + "Ragga\r\n"
            + "Dancehall\r\n"
            + "Ska\r\n"
            + "2 Tone\r\n"
            + "Dub\r\n"
            + "Rocksteady\r\n"
            + "Reggae Dancehall\r\n"
            + "Rock\r\n"
            + "Acid Rock\r\n"
            + "Adult-Oriented Rock\r\n"
            + "Afro Punk\r\n"
            + "Adult Alternative\r\n"
            + "Alternative Rock\r\n"
            + "American Traditional Rock\r\n"
            + "Anatolian Rock\r\n"
            + "Arena Rock\r\n"
            + "Art Rock\r\n"
            + "Blues-Rock\r\n"
            + "British Invasion\r\n"
            + "Cock Rock\r\n"
            + "Death Metal / Black Metal\r\n"
            + "Doom Metal\r\n"
            + "Glam Rock\r\n"
            + "Gothic Metal\r\n"
            + "Grind Core\r\n"
            + "Hair Metal\r\n"
            + "Hard Rock\r\n"
            + "Math Metal\r\n"
            + "Math Rock\r\n"
            + "Metal\r\n"
            + "Metal Core\r\n"
            + "Noise Rock (genre – Japanoise)\r\n"
            + "Jam Bands\r\n"
            + "Post Punk\r\n"
            + "Post Rock\r\n"
            + "Prog-Rock/Art Rock\r\n"
            + "Progressive Metal\r\n"
            + "Psychedelic\r\n"
            + "Rock & Roll\r\n"
            + "Rockabilly\r\n"
            + "Roots Rock\r\n"
            + "Singer/Songwriter\r\n"
            + "Southern Rock\r\n"
            + "Spazzcore\r\n"
            + "Stoner Metal (duuuude)\r\n"
            + "Surf\r\n"
            + "Technical Death Metal\r\n"
            + "Tex-Mex\r\n"
            + "Thrash Metal\r\n"
            + "Time Lord Rock (Trock)\r\n"
            + "Trip-hop\r\n"
            + "Yacht Rock (soft rock)\r\n"
            + "Singer/Songwriter\r\n"
            + "Alternative Folk\r\n"
            + "Contemporary Folk\r\n"
            + "Contemporary Singer/Songwriter\r\n"
            + "Indie Folk\r\n"
            + "Folk-Rock\r\n"
            + "Love Song (Chanson)\r\n"
            + "New Acoustic\r\n"
            + "Traditional Folk\r\n"
            + "Soundtrack\r\n"
            + "Foreign Cinema\r\n"
            + "Movie Soundtrack\r\n"
            + "Musicals\r\n"
            + "Original Score\r\n"
            + "Soundtrack\r\n"
            + "TV Soundtrack\r\n"
            + "Spoken Word\r\n"
            + "Tex-Mex / Tejano\r\n"
            + "Chicano\r\n"
            + "Classic\r\n"
            + "Conjunto\r\n"
            + "Conjunto Progressive\r\n"
            + "New Mex\r\n"
            + "Tex-Mex\r\n"
            + "Vocal\r\n"
            + "A cappella\r\n"
            + "Barbershop\r\n"
            + "Cantique (sacred vocal)\r\n"
            + "Doo-wop\r\n"
            + "Gregorian Chant\r\n"
            + "Standards\r\n"
            + "Traditional Pop\r\n"
            + "Vocal Jazz\r\n"
            + "Vocal Pop\r\n"
            + "Yodel\r\n"
            + "World\r\n"
            + "Africa\r\n"
            + "African Heavy Metal\r\n"
            + "African Hip Hop\r\n"
            + "Afro-Beat\r\n"
            + "Afro-House\r\n"
            + "Afro-Pop\r\n"
            + "Apala (or akpala)\r\n"
            + "Benga\r\n"
            + "Bikutsi\r\n"
            + "Bongo Flava\r\n"
            + "Cape Jazz\r\n"
            + "Chimurenga\r\n"
            + "Coupé-Décalé\r\n"
            + "Fuji Music\r\n"
            + "Genge\r\n"
            + "Gnawa (hypnotic trance)\r\n"
            + "Highlife\r\n"
            + "Hiplife\r\n"
            + "Isicathamiya\r\n"
            + "Jit\r\n"
            + "Jùjú\r\n"
            + "Kapuka\r\n"
            + "Kizomba\r\n"
            + "Kuduro\r\n"
            + "Kwaito\r\n"
            + "Kwela\r\n"
            + "Lingala (Rumba Lingala / Congolese Rumba)\r\n"
            + "Makossa\r\n"
            + "Maloya\r\n"
            + "Marrabenta\r\n"
            + "Mbalax\r\n"
            + "Mbaqanga\r\n"
            + "Mbube\r\n"
            + "Morna\r\n"
            + "Museve\r\n"
            + "Negro Spiritual\r\n"
            + "Palm-Wine\r\n"
            + "Raï\r\n"
            + "Sakara\r\n"
            + "Sega\r\n"
            + "Seggae\r\n"
            + "Semba\r\n"
            + "Soukous\r\n"
            + "Taarab\r\n"
            + "Zouglou\r\n"
            + "Asia\r\n"
            + "Anison\r\n"
            + "Baithak Gana\r\n"
            + "C-Pop\r\n"
            + "CityPop\r\n"
            + "Cantopop\r\n"
            + "Enka\r\n"
            + "Hong Kong English Pop\r\n"
            + "Fann At-Tanbura\r\n"
            + "Fijiri\r\n"
            + "J-Pop\r\n"
            + "Japanese Pop\r\n"
            + "K-Pop\r\n"
            + "Khaliji\r\n"
            + "Kayōkyoku\r\n"
            + "Korean Pop\r\n"
            + "Liwa\r\n"
            + "Mandopop\r\n"
            + "Onkyokei\r\n"
            + "Taiwanese Pop\r\n"
            + "T-Pop (Thai pop)\r\n"
            + "Sawt\r\n"
            + "Australia\r\n"
            + "Cajun\r\n"
            + "Calypso\r\n"
            + "Caribbean\r\n"
            + "Chutney\r\n"
            + "Chutney Soca\r\n"
            + "Compas\r\n"
            + "Mambo\r\n"
            + "Merengue\r\n"
            + "Carnatic (Karnataka Sanghetha)\r\n"
            + "Celtic\r\n"
            + "Celtic Folk\r\n"
            + "Contemporary Celtic\r\n"
            + "Coupé-décalé – Congo\r\n"
            + "Dangdut\r\n"
            + "Drinking Songs\r\n"
            + "Drone\r\n"
            + "Europe – Portugal: Fado music is a form of Portuguese singing that is often associated with pubs, cafés, and restaurants.\r\n"
            + "Europe – Greece: Laiko, Entechno, Rebetika\r\n"
            + "Europe – Germany / Austria / Sweden / UK: Schlager (varies by country)\r\n"
            + "France\r\n"
            + "Hawaii\r\n"
            + "Japan\r\n"
            + "Klezmer\r\n"
            + "Mbalax – Senegal\r\n"
            + "Middle East\r\n"
            + "North America\r\n"
            + "Ode\r\n"
            + "Piphat – Thailand\r\n"
            + "Polka\r\n"
            + "Soca\r\n"
            + "South Africa\r\n"
            + "South America\r\n"
            + "South / Southeast Asia\r\n"
            + "Baila\r\n"
            + "Bhangra\r\n"
            + "Bhojpuri\r\n"
            + "Dangdut\r\n"
            + "Filmi\r\n"
            + "Indian Pop\r\n"
            + "Hindustani\r\n"
            + "Indian Ghazal\r\n"
            + "Lavani\r\n"
            + "Luk Thung\r\n"
            + "Luk Krung\r\n"
            + "Manila Sound\r\n"
            + "Morlam\r\n"
            + "Pinoy Pop\r\n"
            + "Pop Sunda\r\n"
            + "Ragini\r\n"
            + "Thai Pop\r\n"
            + "Traditional Celtic\r\n"
            + "Worldbeat\r\n"
            + "Zydeco\r\n"
            + "\r\n"
            + "";
	/**
	 * music genres list turned into an array
	 */
	private final static String [] Genres = baseList.split("\r");
	
	//genres list home directory
	static private final String home = System.getProperty("user.home");
	//path towards the genres binary files
	static private final String path = home + "\\GenreDive\\GenreList\\MusicGenresList";
	
	static private final File folder = new File(home + "\\GenreDive\\\\GenreList");
	
	private final static String name = "Music Genres List";
	
	private final static SeralizationControler J = new SeralizationControler ();
	
	private final static HashMap<String,Usuario> UserData = new HashMap<>();
	
	public String getBaseList() {
		return baseList;
	}

	public String[] getGenres() {
		return Genres;
	}

	@Override
	public String toString() {
		return "GenreList [Genres=" + Arrays.toString(Genres) + "]";
	}
	/**
	 * method in charge of creating the directory holding the music genres list
	 */
	public static void createList () {
		folder.mkdirs();
		J.serializarStringA(Genres, path);
	}
	public static void createUserData(){
		
		Usuario user1 = new Usuario ("Allie","Chigwi23");
		
		Usuario user2 = new Usuario ("Salo","Salo123");
		
		Usuario user3 = new Usuario ("Cothu","Chotu");
		
		Usuario last = user1;
		
		UserData.put("Allie", user1);
		
		UserData.put("Salo", user2);
		
		UserData.put("Cothu", user3);
		
		UserData.put("last", last);
		
		System.out.println(UserData.get("last"));
		
		J.serializarUser(UserData,"src/main/resources/users/userData.bin");
	}

}
