CREATE TABLE `user_profile` (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `fullname` varchar(100) NOT NULL,
                                `email` varchar(100) NOT NULL,
                                `picture` varchar(100) DEFAULT NULL,
                                `description` text,
                                `mbti` varchar(100) DEFAULT NULL,
                                `enneagram` varchar(100) DEFAULT NULL,
                                `variant` varchar(100) DEFAULT NULL,
                                `tritype` int DEFAULT NULL,
                                `socionics` varchar(100) DEFAULT NULL,
                                `sloan` varchar(100) DEFAULT NULL,
                                `psyche` varchar(100) DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                KEY `user_profile_fullname_IDX` (`fullname`,`email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `profile_engagement` (
                                      `id` int NOT NULL AUTO_INCREMENT,
                                      `profile_id` int NOT NULL,
                                      `type` enum('comment','like','dislike') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'comment',
                                      `comment_by` int NOT NULL,
                                      `message` text,
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

