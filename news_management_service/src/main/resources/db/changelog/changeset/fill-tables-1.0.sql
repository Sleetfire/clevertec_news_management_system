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
        'Wayne Rooney''s record (53) to do so. Following this, Harry Kane shared a post on Twitter.');

select setval('news_management_service.news_id_seq', (SELECT MAX(id) FROM news_management_service.news));

INSERT INTO news_management_service.comments (time, text, username, news_id)
VALUES ('2023-05-08 09:05:00.000000', 'superb', 'user1',
        (select id from news_management_service.news where "title" like '%Cristiano Ronaldo opens up%')),
       ('2023-05-08 09:10:00.000000', 'nice', 'user2',
        (select id from news_management_service.news where "title" like '%Cristiano Ronaldo opens up%')),
       ('2023-05-08 09:15:00.000000', 'cool', 'user3',
        (select id from news_management_service.news where "title" like '%Cristiano Ronaldo opens up%')),
       ('2023-05-08 09:20:00.000000', 'fantastic', 'user4',
        (select id from news_management_service.news where "title" like '%Cristiano Ronaldo opens up%')),
       ('2023-05-08 09:25:00.000000', 'wow', 'user5',
        (select id from news_management_service.news where "title" like '%Cristiano Ronaldo opens up%')),
       ('2023-05-08 09:30:00.000000', 'top', 'user6',
        (select id from news_management_service.news where "title" like '%Cristiano Ronaldo opens up%')),
       ('2023-05-08 09:35:00.000000', 'G.O.A.T.', 'user7',
        (select id from news_management_service.news where "title" like '%Cristiano Ronaldo opens up%')),
       ('2023-05-08 09:40:00.000000', 'simply the best', 'user8',
        (select id from news_management_service.news where "title" like '%Cristiano Ronaldo opens up%')),
       ('2023-05-08 09:45:00.000000', 'I hate him', 'user9',
        (select id from news_management_service.news where "title" like '%Cristiano Ronaldo opens up%')),
       ('2023-05-08 09:50:00.000000', 'take my energy', 'user10',
        (select id from news_management_service.news where "title" like '%Cristiano Ronaldo opens up%')),

       ('2023-05-08 12:05:00.000000', 'superb', 'user1',
        (select id from news_management_service.news where "title" like '%Man Utd looking to get Neymar after PSG%')),
       ('2023-05-08 12:10:00.000000', 'nice', 'user2',
        (select id from news_management_service.news where "title" like '%Man Utd looking to get Neymar after PSG%')),
       ('2023-05-08 12:15:00.000000', 'cool', 'user3',
        (select id from news_management_service.news where "title" like '%Man Utd looking to get Neymar after PSG%')),
       ('2023-05-08 12:20:00.000000', 'fantastic', 'user4',
        (select id from news_management_service.news where "title" like '%Man Utd looking to get Neymar after PSG%')),
       ('2023-05-08 12:25:00.000000', 'wow', 'user5',
        (select id from news_management_service.news where "title" like '%Man Utd looking to get Neymar after PSG%')),
       ('2023-05-08 12:30:00.000000', 'top', 'user6',
        (select id from news_management_service.news where "title" like '%Man Utd looking to get Neymar after PSG%')),
       ('2023-05-08 12:35:00.000000', 'G.O.A.T.', 'user7',
        (select id from news_management_service.news where "title" like '%Man Utd looking to get Neymar after PSG%')),
       ('2023-05-08 12:40:00.000000', 'simply the best', 'user8',
        (select id from news_management_service.news where "title" like '%Man Utd looking to get Neymar after PSG%')),
       ('2023-05-08 12:45:00.000000', 'I hate him', 'user9',
        (select id from news_management_service.news where "title" like '%Man Utd looking to get Neymar after PSG%')),
       ('2023-05-08 12:50:00.000000', 'take my energy', 'user10',
        (select id from news_management_service.news where "title" like '%Man Utd looking to get Neymar after PSG%')),

       ('2023-05-08 15:05:00.000000', 'superb', 'user1',
        (select id from news_management_service.news where "title" like '%Lionel Messi and Carlos Alcaraz handshake%')),
       ('2023-05-08 15:10:00.000000', 'nice', 'user2',
        (select id from news_management_service.news where "title" like '%Lionel Messi and Carlos Alcaraz handshake%')),
       ('2023-05-08 15:15:00.000000', 'cool', 'user3',
        (select id from news_management_service.news where "title" like '%Lionel Messi and Carlos Alcaraz handshake%')),
       ('2023-05-08 15:20:00.000000', 'fantastic', 'user4',
        (select id from news_management_service.news where "title" like '%Lionel Messi and Carlos Alcaraz handshake%')),
       ('2023-05-08 15:25:00.000000', 'wow', 'user5',
        (select id from news_management_service.news where "title" like '%Lionel Messi and Carlos Alcaraz handshake%')),
       ('2023-05-08 15:30:00.000000', 'top', 'user6',
        (select id from news_management_service.news where "title" like '%Lionel Messi and Carlos Alcaraz handshake%')),
       ('2023-05-08 15:35:00.000000', 'G.O.A.T.', 'user7',
        (select id from news_management_service.news where "title" like '%Lionel Messi and Carlos Alcaraz handshake%')),
       ('2023-05-08 15:40:00.000000', 'simply the best', 'user8',
        (select id from news_management_service.news where "title" like '%Lionel Messi and Carlos Alcaraz handshake%')),
       ('2023-05-08 15:45:00.000000', 'I hate him', 'user9',
        (select id from news_management_service.news where "title" like '%Lionel Messi and Carlos Alcaraz handshake%')),
       ('2023-05-08 15:50:00.000000', 'take my energy', 'user10',
        (select id from news_management_service.news where "title" like '%Lionel Messi and Carlos Alcaraz handshake%')),

       ('2023-05-08 18:05:00.000000', 'superb', 'user1',
        (select id from news_management_service.news where "title" like '%Lionel Messi apologises to fans%')),
       ('2023-05-08 18:10:00.000000', 'nice', 'user2',
        (select id from news_management_service.news where "title" like '%Lionel Messi apologises to fans%')),
       ('2023-05-08 18:15:00.000000', 'cool', 'user3',
        (select id from news_management_service.news where "title" like '%Lionel Messi apologises to fans%')),
       ('2023-05-08 18:20:00.000000', 'fantastic', 'user4',
        (select id from news_management_service.news where "title" like '%Lionel Messi apologises to fans%')),
       ('2023-05-08 18:25:00.000000', 'wow', 'user5',
        (select id from news_management_service.news where "title" like '%Lionel Messi apologises to fans%')),
       ('2023-05-08 18:30:00.000000', 'top', 'user6',
        (select id from news_management_service.news where "title" like '%Lionel Messi apologises to fans%')),
       ('2023-05-08 18:35:00.000000', 'G.O.A.T.', 'user7',
        (select id from news_management_service.news where "title" like '%Lionel Messi apologises to fans%')),
       ('2023-05-08 18:40:00.000000', 'simply the best', 'user8',
        (select id from news_management_service.news where "title" like '%Lionel Messi apologises to fans%')),
       ('2023-05-08 18:45:00.000000', 'I hate him', 'user9',
        (select id from news_management_service.news where "title" like '%Lionel Messi apologises to fans%')),
       ('2023-05-08 18:50:00.000000', 'take my energy', 'user10',
        (select id from news_management_service.news where "title" like '%Lionel Messi apologises to fans%')),

       ('2023-05-08 21:05:00.000000', 'superb', 'user1',
        (select id from news_management_service.news where "title" like '%Ding Liren succeeds Magnus Carlsen%')),
       ('2023-05-08 21:10:00.000000', 'nice', 'user2',
        (select id from news_management_service.news where "title" like '%Ding Liren succeeds Magnus Carlsen%')),
       ('2023-05-08 21:15:00.000000', 'cool', 'user3',
        (select id from news_management_service.news where "title" like '%Ding Liren succeeds Magnus Carlsen%')),
       ('2023-05-08 21:20:00.000000', 'fantastic', 'user4',
        (select id from news_management_service.news where "title" like '%Ding Liren succeeds Magnus Carlsen%')),
       ('2023-05-08 21:25:00.000000', 'wow', 'user5',
        (select id from news_management_service.news where "title" like '%Ding Liren succeeds Magnus Carlsen%')),
       ('2023-05-08 21:30:00.000000', 'top', 'user6',
        (select id from news_management_service.news where "title" like '%Ding Liren succeeds Magnus Carlsen%')),
       ('2023-05-08 21:35:00.000000', 'G.O.A.T.', 'user7',
        (select id from news_management_service.news where "title" like '%Ding Liren succeeds Magnus Carlsen%')),
       ('2023-05-08 21:40:00.000000', 'simply the best', 'user8',
        (select id from news_management_service.news where "title" like '%Ding Liren succeeds Magnus Carlsen%')),
       ('2023-05-08 21:45:00.000000', 'I hate him', 'user9',
        (select id from news_management_service.news where "title" like '%Ding Liren succeeds Magnus Carlsen%')),
       ('2023-05-08 21:50:00.000000', 'take my energy', 'user10',
        (select id from news_management_service.news where "title" like '%Ding Liren succeeds Magnus Carlsen%')),

       ('2023-05-09 06:05:00.000000', 'superb', 'user1',
        (select id from news_management_service.news where "title" like '%Lionel Messi ties Cristiano Ronaldo’s%')),
       ('2023-05-09 06:10:00.000000', 'nice', 'user2',
        (select id from news_management_service.news where "title" like '%Lionel Messi ties Cristiano Ronaldo’s%')),
       ('2023-05-09 06:15:00.000000', 'cool', 'user3',
        (select id from news_management_service.news where "title" like '%Lionel Messi ties Cristiano Ronaldo’s%')),
       ('2023-05-09 06:20:00.000000', 'fantastic', 'user4',
        (select id from news_management_service.news where "title" like '%Lionel Messi ties Cristiano Ronaldo’s%')),
       ('2023-05-09 06:25:00.000000', 'wow', 'user5',
        (select id from news_management_service.news where "title" like '%Lionel Messi ties Cristiano Ronaldo’s%')),
       ('2023-05-09 06:30:00.000000', 'top', 'user6',
        (select id from news_management_service.news where "title" like '%Lionel Messi ties Cristiano Ronaldo’s%')),
       ('2023-05-09 06:35:00.000000', 'G.O.A.T.', 'user7',
        (select id from news_management_service.news where "title" like '%Lionel Messi ties Cristiano Ronaldo’s%')),
       ('2023-05-09 06:40:00.000000', 'simply the best', 'user8',
        (select id from news_management_service.news where "title" like '%Lionel Messi ties Cristiano Ronaldo’s%')),
       ('2023-05-09 06:45:00.000000', 'I hate him', 'user9',
        (select id from news_management_service.news where "title" like '%Lionel Messi ties Cristiano Ronaldo’s%')),
       ('2023-05-09 06:50:00.000000', 'take my energy', 'user10',
        (select id from news_management_service.news where "title" like '%Lionel Messi ties Cristiano Ronaldo’s%')),

       ('2023-05-09 09:05:00.000000', 'superb', 'user1',
        (select id from news_management_service.news where "title" like '%Lionel Messi honoured with statue%')),
       ('2023-05-09 09:10:00.000000', 'nice', 'user2',
        (select id from news_management_service.news where "title" like '%Lionel Messi honoured with statue%')),
       ('2023-05-09 09:15:00.000000', 'cool', 'user3',
        (select id from news_management_service.news where "title" like '%Lionel Messi honoured with statue%')),
       ('2023-05-09 09:20:00.000000', 'fantastic', 'user4',
        (select id from news_management_service.news where "title" like '%Lionel Messi honoured with statue%')),
       ('2023-05-09 09:25:00.000000', 'wow', 'user5',
        (select id from news_management_service.news where "title" like '%Lionel Messi honoured with statue%')),
       ('2023-05-09 09:30:00.000000', 'top', 'user6',
        (select id from news_management_service.news where "title" like '%Lionel Messi honoured with statue%')),
       ('2023-05-09 09:35:00.000000', 'G.O.A.T.', 'user7',
        (select id from news_management_service.news where "title" like '%Lionel Messi honoured with statue%')),
       ('2023-05-09 09:40:00.000000', 'simply the best', 'user8',
        (select id from news_management_service.news where "title" like '%Lionel Messi honoured with statue%')),
       ('2023-05-09 09:45:00.000000', 'I hate him', 'user9',
        (select id from news_management_service.news where "title" like '%Lionel Messi honoured with statue%')),
       ('2023-05-09 09:50:00.000000', 'take my energy', 'user10',
        (select id from news_management_service.news where "title" like '%Lionel Messi honoured with statue%')),

       ('2023-05-09 12:05:00.000000', 'superb', 'user1',
        (select id from news_management_service.news where "title" like '%Lionel Messi becomes 2nd player%')),
       ('2023-05-09 12:10:00.000000', 'nice', 'user2',
        (select id from news_management_service.news where "title" like '%Lionel Messi becomes 2nd player%')),
       ('2023-05-09 12:15:00.000000', 'cool', 'user3',
        (select id from news_management_service.news where "title" like '%Lionel Messi becomes 2nd player%')),
       ('2023-05-09 12:20:00.000000', 'fantastic', 'user4',
        (select id from news_management_service.news where "title" like '%Lionel Messi becomes 2nd player%')),
       ('2023-05-09 12:25:00.000000', 'wow', 'user5',
        (select id from news_management_service.news where "title" like '%Lionel Messi becomes 2nd player%')),
       ('2023-05-09 12:30:00.000000', 'top', 'user6',
        (select id from news_management_service.news where "title" like '%Lionel Messi becomes 2nd player%')),
       ('2023-05-09 12:35:00.000000', 'G.O.A.T.', 'user7',
        (select id from news_management_service.news where "title" like '%Lionel Messi becomes 2nd player%')),
       ('2023-05-09 12:40:00.000000', 'simply the best', 'user8',
        (select id from news_management_service.news where "title" like '%Lionel Messi becomes 2nd player%')),
       ('2023-05-09 12:45:00.000000', 'I hate him', 'user9',
        (select id from news_management_service.news where "title" like '%Lionel Messi becomes 2nd player%')),
       ('2023-05-09 12:50:00.000000', 'take my energy', 'user10',
        (select id from news_management_service.news where "title" like '%Lionel Messi becomes 2nd player%')),

       ('2023-05-09 15:05:00.000000', 'superb', 'user1',
        (select id from news_management_service.news where "title" like '%Harry Kane becomes England’s%')),
       ('2023-05-09 15:10:00.000000', 'nice', 'user2',
        (select id from news_management_service.news where "title" like '%Harry Kane becomes England’s%')),
       ('2023-05-09 15:15:00.000000', 'cool', 'user3',
        (select id from news_management_service.news where "title" like '%Harry Kane becomes England’s%')),
       ('2023-05-09 15:20:00.000000', 'fantastic', 'user4',
        (select id from news_management_service.news where "title" like '%Harry Kane becomes England’s%')),
       ('2023-05-09 15:25:00.000000', 'wow', 'user5',
        (select id from news_management_service.news where "title" like '%Harry Kane becomes England’s%')),
       ('2023-05-09 15:30:00.000000', 'top', 'user6',
        (select id from news_management_service.news where "title" like '%Harry Kane becomes England’s%')),
       ('2023-05-09 15:35:00.000000', 'G.O.A.T.', 'user7',
        (select id from news_management_service.news where "title" like '%Harry Kane becomes England’s%')),
       ('2023-05-09 15:40:00.000000', 'simply the best', 'user8',
        (select id from news_management_service.news where "title" like '%Harry Kane becomes England’s%')),
       ('2023-05-09 15:45:00.000000', 'I hate him', 'user9',
        (select id from news_management_service.news where "title" like '%Harry Kane becomes England’s%')),
       ('2023-05-09 15:50:00.000000', 'take my energy', 'user10',
        (select id from news_management_service.news where "title" like '%Harry Kane becomes England’s%'));

select setval('news_management_service.comments_id_seq', (SELECT MAX(id) FROM news_management_service.comments));