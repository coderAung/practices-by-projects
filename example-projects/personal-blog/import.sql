-- Insert data into the Category table
INSERT INTO Category (createdAt, name) VALUES
('2024-01-01', 'Technology'),
('2024-01-02', 'Health'),
('2024-01-03', 'Education'),
('2024-01-04', 'Sports');

-- Insert data into the User table
INSERT INTO User (email, name, password, profileImage) VALUES
('john.doe@example.com', 'John Doe', 'password', 'profile1.jpg'),
('jane.smith@example.com', 'Jane Smith', 'password', 'profile2.jpg'),
('alice.wonderland@example.com', 'Alice Wonderland', 'password', 'profile3.jpg'),
('bob.marley@example.com', 'Bob Marley', 'password', 'profile4.jpg');

-- Insert data into the Post table
INSERT INTO Post (category_id, postAt, user_id, content, title) VALUES
(1, '2024-02-01', 1, 'In today’s rapidly evolving world, technology continues to push boundaries and redefine how we interact with the world. From advancements in artificial intelligence to breakthroughs in renewable energy, technology in 2024 promises to be transformative. AI applications are becoming smarter, personalized tech experiences are more common, and emerging technologies like blockchain and 5G are improving connectivity and trust across industries. As we look to the future, businesses and individuals must embrace these changes to remain competitive and sustainable.', 'Technology Trends in 2024'),
(2, '2024-02-02', 2, 'Healthy living starts with small, consistent habits. Whether it’s waking up early to start the day with a morning walk or practicing mindfulness meditation, these routines can make a huge difference. Studies show that people who maintain structured mornings often have better mental clarity and productivity. Simple steps like drinking enough water, stretching, and eating a balanced breakfast set the tone for a successful and positive day. Remember, health is wealth, and small changes lead to big results over time.', 'Health Benefits of Morning Routines'),
(3, '2024-02-03', 3, 'Online education has transformed learning by making it accessible to anyone, anywhere. However, succeeding in online education requires discipline and structure. Students need to manage their time effectively, create a dedicated study space, and engage actively with course materials. Tools like digital planners and group discussions can help keep students on track. Moreover, staying connected with peers and instructors can bridge the gap often felt in virtual learning environments. By adopting the right strategies, anyone can excel in online education.', 'How to Succeed in Online Education'),
(4, '2024-02-04', 4, 'The world of sports continues to captivate millions with its passion, skill, and excitement. As we enter 2024, football enthusiasts are gearing up for some of the most anticipated matches and tournaments. From domestic leagues to international showdowns, teams are displaying immense talent and dedication. Fans can look forward to thrilling rivalries, last-minute goals, and incredible moments of teamwork that define the beauty of the sport. Stay tuned as we bring you highlights, updates, and exclusive insights throughout the year.', 'Football Highlights: Upcoming Matches and News');

-- Insert data into the Comment table
INSERT INTO Comment (post_id, text) VALUES
(1, 'Great insights on technology! I love how AI is changing our lives.'),
(1, 'This is very informative. Thanks for sharing!'),
(2, 'Morning routines truly make a difference. I feel much more productive now.'),
(3, 'These tips for online learning are so helpful! Managing time is key.'),
(4, 'Excited for the new season! Can’t wait to see my favorite team in action.');
