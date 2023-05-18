--liquibase formatted sql

--changeset Sleetfire:fill-tables

INSERT INTO news_management_service.news (time, title, text)
VALUES ('2023-05-08 09:00:00.000000', 'Cristiano Ronaldo opens up on his controversial Manchester United exit; ' ||
                                      'says ‘Now I’m a better man’',
        'Portugal captain Cristiano Ronaldo has opened up on his controversial exit from Manchester United, ' ||
        'admitting that he had never been through this phase in his career but "he is a better man" ' ||
        'following his painful experience few months ago. The Portugal international also said that it was a ' ||
        'bad career decision to rejoin the United in 2021.'),

       ('2023-05-08 12:00:00.000000', 'Man Utd looking to get Neymar after PSG''s loss of faith',
        'Paris Saint-Germain are reportedly looking to sell Brazilian forward Neymar at the end of this season, ' ||
        'with Manchester United, Juventus, and Newcastle United interested in acquiring his services. PSG are said ' ||
        'to have no faith in the 31-year-old with his current market value being pegged at €70 million. Neymar ' ||
        'joined PSG in 2017 for a world record €222 million fee.'),

       ('2023-05-08 15:00:00.000000', 'Lionel Messi and Carlos Alcaraz handshake photo from 2023 Laureus World ' ||
                                      'Sports Awards goes viral',
        'Laureaus World Sports Awards is an event where sportspersons from all across the world come to ' ||
        'witness the mega event. In this case, two of most accomplished sports personalities participated in the ' ||
        'event. Argentina’s World Cup winning footballer, Lionel Messi, and Madrid Open Champion, ' ||
        'Carlos Alcaraz featured in the event. In a photo that went viral shows two of the most successful ' ||
        'world champions – Messi and Alcaraz – shaking hands with each other.'),

       ('2023-05-08 18:00:00.000000', 'Lionel Messi wins Laureus World Sportsman of the Year 2023 award',
        'Lionel Messi won the Laureus World Sportsman of the Year 2023 award. The star player reached the pinnacle ' ||
        'of success of his glorious career when he led his nation Argentina to the FIFA World Cup 2022 title after ' ||
        'a thrilling final against France. Messi was also named winner of the Golden Ball of the tournament held ' ||
        'in Qatar. That was his second golden ball award after winning one in 2014.'),

       ('2023-05-08 21:00:00.000000', 'Lionel Messi apologises to fans after suspension by his club PSG for ' ||
                                      '‘unauthorised’ trip to Saudi Arabia',
        'Paris Saint-Germain forward Lionel Messi has apologised for his ''unauthorised'' trip to Saudi Arabia that ' ||
        'has led to his suspension by the French club. The Argentine was suspended from the club on May 2 and he ' ||
        'would not be included in the training sessions as well. Messi admitted in an apology video ' ||
        'on Instagram where he said: " I want to apologise to my teammates and the club."'),

       ('2023-05-09 06:00:00.000000', 'Ding Liren succeeds Magnus Carlsen as new world chess champion, ' ||
                                      'beats Ian Nepomniachtchi in 2023 FIDE World Championship final',
        'China''s Ding Liren made history by becoming the 17th FIDE World Champion in chess, defeating Ian ' ||
        'Nepomniachtchi in the final game of the tiebreak here on Sunday. Both Ding and Nepomniachtchi ' ||
        'finished 7-7 after exhilarating 14 classical games, taking the match into the tie-breaker. ' ||
        'Ding Liren becomes the first Chinese male player to win the chess world championship.'),

       ('2023-05-09 09:00:00.000000', 'Lionel Messi ties Cristiano Ronaldo’s record, becomes the joint-highest goal ' ||
                                      'scorer in European top five leagues',
        'Lionel Messi is known for breaking records throughout his career. The Argentine superstar has now become ' ||
        'the joint-highest goalscorer in the top five leagues of Europe. Messi achieved this feat in ' ||
        'Paris Saint-Germain''s recent Ligue 1 match against RC Lens at Parc des Princes, Paris. ' ||
        'PSG meanwhile registered a 3-1 victory with Kylian Mbappe, Vitinha and Lionel Messi scoring the goals for ' ||
        'the defending Ligue 1 champions.'),

       ('2023-05-09 12:00:00.000000', 'Lionel Messi honoured with statue celebrating his FIFA World Cup 2022 win at ' ||
                                      'CONMEBOL museum',
        'The tributes continue to pour in for Lionel Messi following Argentina''s World Cup triumph. ' ||
        'South American soccer''s governing body on Monday presented the 35-year-old Argentine star with a statue, ' ||
        'which will be placed in the CONMEBOL museum next to those of legendary players Pelé and Diego Maradona. ' ||
        'Messi also received replicas of the World Cup and the Finalissima trophy.'),

       ('2023-05-09 15:00:00.000000', 'Lionel Messi becomes 2nd player with 800 career goals',
        'Lionel Messi added another feather to this already-illustrious hat as he has become only the second player ' ||
        'after rival Cristiano Ronaldo to complete 800 career goals. He accomplished the milestone with a goal in ' ||
        'Argentina''s 2-0 friendly win over Panama. Notably, it was Argentina''s maiden outing in international ' ||
        'football since lifting the FIFA World Cup 2022 title last December'),

       ('2023-05-09 18:00:00.000000', 'Harry Kane becomes England’s top goalscorer',
        'Tottenham Hotspur forward Harry Kane scored from the penalty spot as England registered a 2-1 ' ||
        'victory against Italy in their latest UEFA Euro 2024 Qualifiers match at Stadio Diego Armando Maradona, ' ||
        'Naples. With this goal, Harry Kane (54) became the top scorer for England. The Tottenham forward broke ' ||
        'Wayne Rooney''s record (53) to do so. Following this, Harry Kane shared a post on Twitter.'),

       ('2023-05-09 18:00:00.000000', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit',
        'Curabitur elit libero,' ||
        ' tincidunt sit amet ultrices hendrerit, consequat et eros. Duis a iaculis sem. Morbi varius nec nisi ut ' ||
        'tristique. Duis convallis augue et erat condimentum, eu pulvinar ipsum ultrices. Phasellus in lectus ac ' ||
        'ligula tempus semper in ultrices ligula. Sed rhoncus blandit ligula id tincidunt. Vivamus a convallis quam. ' ||
        'Suspendisse eleifend odio vitae erat egestas, et aliquam massa dapibus. Vivamus ut lorem quis purus ' ||
        'pharetra accumsan. Donec magna est, finibus sed ipsum vitae, rutrum blandit lacus.'),

       ('2023-05-09 18:00:00.000000', 'Donec magna est, finibus sed ipsum vitae',
        'rutrum blandit lacus. Maecenas commodo ut ex eget varius. Vestibulum justo sapien, tempor vel mauris imperdiet, ' ||
        'malesuada vulputate diam. Maecenas non massa iaculis, ornare mi in, tincidunt velit.'),

       ('2023-05-09 18:00:00.000000', 'Donec ut sollicitudin lorem. Vivamus lobortis lacus at massa ornare pretium',
        'Donec ut sollicitudin lorem. Vivamus lobortis lacus at massa ornare pretium'),

       ('2023-05-09 18:00:00.000000',
        'Vivamus purus odio, tincidunt ut rhoncus ut, molestie quis neque. Maecenas pretium tellus diam, viverra pharetra nunc aliquet ac',
        'Duis posuere leo eu odio dictum pulvinar. Proin sit amet urna lacus. Nam tristique lobortis mi, nec vulputate magna tincidunt ut'),

       ('2023-05-09 18:00:00.000000',
        'Sed at rutrum massa, a finibus elit',
        'Phasellus sit amet sem mauris. Donec in metus ligula. Ut vulputate cursus tortor vitae aliquam. ' ||
        'Etiam consectetur sollicitudin mauris sit amet vestibulum. Nulla sapien nisl, cursus lobortis volutpat ut, ' ||
        'cursus vitae dolor.'),

       ('2023-05-09 18:00:00.000000',
        'Nullam fringilla facilisis ipsum, a tempus risus condimentum ac',
        'Aenean vulputate magna vitae orci commodo, eu commodo eros aliquet'),

       ('2023-05-09 18:00:00.000000',
        'Praesent pharetra ex eget nibh dignissim pretium',
        'Donec sit amet sagittis mi. Proin eget imperdiet ipsum. Aenean gravida ligula eget odio ultricies blandit'),

       ('2023-05-09 18:00:00.000000',
        'Proin euismod aliquet magna sit amet mattis',
        'Aliquam at sodales ante, id efficitur lacus. In magna sem, consectetur et elit vel, fringilla pellentesque odio'),

       ('2023-05-09 18:00:00.000000',
        'Duis sed rutrum eros, at ornare sem',
        'Nam et mollis velit. Praesent sodales, mauris nec posuere lobortis, libero metus elementum ligula, ' ||
        'ac dictum nisi velit sed tortor. Duis sodales tincidunt enim, in tristique ligula.'),

       ('2023-05-09 18:00:00.000000',
        'Curabitur id euismod nibh',
        'Nulla dui ipsum, mollis vel dignissim eget, euismod nec nisl');

select setval('news_management_service.news_id_seq', (SELECT MAX(id) FROM news_management_service.news));

INSERT INTO news_management_service.comments (time, text, username, news_id)
VALUES ('2023-05-08 09:05:00.000000', 'superb', 'user1', 1),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 1),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 1),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 1),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 1),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 1),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 1),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 1),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 1),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 1),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 2),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 2),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 2),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 2),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 2),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 2),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 2),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 2),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 2),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 2),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 3),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 3),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 3),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 3),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 3),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 3),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 3),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 3),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 3),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 3),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 4),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 4),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 4),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 4),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 4),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 4),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 4),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 4),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 4),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 4),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 5),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 5),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 5),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 5),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 5),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 5),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 5),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 5),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 5),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 5),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 6),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 6),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 6),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 6),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 6),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 6),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 6),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 6),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 6),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 6),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 7),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 7),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 7),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 7),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 7),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 7),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 7),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 7),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 7),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 7),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 8),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 8),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 8),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 8),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 8),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 8),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 8),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 8),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 8),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 8),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 9),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 9),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 9),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 9),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 9),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 9),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 9),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 9),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 9),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 9),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 10),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 10),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 10),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 10),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 10),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 10),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 10),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 10),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 10),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 10),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 11),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 11),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 11),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 11),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 11),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 11),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 11),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 11),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 11),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 11),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 12),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 12),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 12),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 12),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 12),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 12),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 12),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 12),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 12),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 12),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 13),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 13),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 13),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 13),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 13),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 13),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 13),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 13),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 13),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 13),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 14),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 14),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 14),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 14),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 14),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 14),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 14),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 14),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 14),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 14),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 15),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 15),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 15),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 15),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 15),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 15),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 15),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 15),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 15),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 15),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 16),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 16),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 16),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 16),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 16),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 16),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 16),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 16),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 16),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 16),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 17),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 17),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 17),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 17),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 17),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 17),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 17),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 17),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 17),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 17),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 18),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 18),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 18),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 18),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 18),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 18),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 18),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 18),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 18),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 18),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 19),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 19),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 19),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 19),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 19),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 19),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 19),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 19),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 19),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 19),

       ('2023-05-08 09:05:00.000000', 'superb', 'user1', 20),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2', 20),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3', 20),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4', 20),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5', 20),
       ('2023-05-08 09:30:00.000000', 'top', 'user6', 20),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7', 20),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8', 20),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9', 20),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10', 20);

select setval('news_management_service.comments_id_seq', (SELECT MAX(id) FROM news_management_service.comments));