## Building and running
1. Install Java 21 via SDKMan (https://sdkman.io/), if you do not already have it installed
2. Recommended IDE: https://www.jetbrains.com/idea/ (Community Edition is sufficient)
3. Clone this repository. Launch IDEA and open the project directory.
5. Modify the database connection settings to point to your local DB
6. Run `my.example.Application` class in your favorite IDE
7. Verify the application is running by curling `localhost:8080/`


### Via CLI
1. Run `./gradlew test`

### API Documentation
1. Create Profile
```
   curl --location 'localhost:8080/profile' \
   --header 'Content-Type: application/json' \
   --header 'Cookie: language=eyJpdiI6IkhFRXBmcjFYK1FiUURpaEQ5UXpGZkE9PSIsInZhbHVlIjoid2pWSWVQTEV4bmVKaWpua21HaW0rZz09IiwibWFjIjoiMjk5NGI4ZWI1NzlkNmNkMjYyNzcxOTk0NWY3ZTM2NDk3M2JlMTlkMWFmOWY2MDlkNmJjYjg3MmZiMGMwYzAwZiJ9' \
   --data-raw ' {
   "email": "test@gmail.com",
   "fullName" : "test aaaa",
   "description": "Adolph Larrue Martinez III.",
   "mbti": "ISFJ",
   "enneagram": "9w3",
   "variant": "sp/so",
   "tritype": 725,
   "socionics": "SEE",
   "sloan": "RCOEN",
   "psyche": "FEVL",
   "picture": "https://soulverse.boo.world/images/1.png"
   }'
```
2. Get Profile
```
curl --location --request GET 'localhost:8080/profile/1' \
--header 'Content-Type: application/json' \
--header 'Cookie: language=eyJpdiI6IkhFRXBmcjFYK1FiUURpaEQ5UXpGZkE9PSIsInZhbHVlIjoid2pWSWVQTEV4bmVKaWpua21HaW0rZz09IiwibWFjIjoiMjk5NGI4ZWI1NzlkNmNkMjYyNzcxOTk0NWY3ZTM2NDk3M2JlMTlkMWFmOWY2MDlkNmJjYjg3MmZiMGMwYzAwZiJ9' \
--data-raw ' {
    "email": "test@gmail.com",
    "fullName" : "test aaaa",
    "description": "Adolph Larrue Martinez III.",
    "mbti": "ISFJ",
    "enneagram": "9w3",
    "variant": "sp/so",
    "tritype": 725,
    "socionics": "SEE",
    "sloan": "RCOEN",
    "psyche": "FEVL",
    "picture": "https://soulverse.boo.world/images/1.png"
  }'
```
3. Put Comment
```
curl --location --request PUT 'localhost:8080/content/1' \
--header 'Content-Type: application/json' \
--header 'Cookie: language=eyJpdiI6IkhFRXBmcjFYK1FiUURpaEQ5UXpGZkE9PSIsInZhbHVlIjoid2pWSWVQTEV4bmVKaWpua21HaW0rZz09IiwibWFjIjoiMjk5NGI4ZWI1NzlkNmNkMjYyNzcxOTk0NWY3ZTM2NDk3M2JlMTlkMWFmOWY2MDlkNmJjYjg3MmZiMGMwYzAwZiJ9' \
--data-raw ' {
    "email": "testaaaaa@gmail.com",
    "fullName" : "testasdasdasdas aaaa",
    "message": "Hail To king"
  }'
```
4. Put Like
```
curl --location --request PUT 'localhost:8080/content/1/like' \
--header 'Content-Type: application/json' \
--header 'Cookie: language=eyJpdiI6IkhFRXBmcjFYK1FiUURpaEQ5UXpGZkE9PSIsInZhbHVlIjoid2pWSWVQTEV4bmVKaWpua21HaW0rZz09IiwibWFjIjoiMjk5NGI4ZWI1NzlkNmNkMjYyNzcxOTk0NWY3ZTM2NDk3M2JlMTlkMWFmOWY2MDlkNmJjYjg3MmZiMGMwYzAwZiJ9' \
--data-raw ' {
    "email": "testaaaaa@gmail.com",
    "fullName" : "testasdasdasdas aaaa"
  }'
```
5. Get Profile Engagement
```
curl --location 'localhost:8080/content/profile?id=1&type=comment' \
--header 'Cookie: language=eyJpdiI6IkhFRXBmcjFYK1FiUURpaEQ5UXpGZkE9PSIsInZhbHVlIjoid2pWSWVQTEV4bmVKaWpua21HaW0rZz09IiwibWFjIjoiMjk5NGI4ZWI1NzlkNmNkMjYyNzcxOTk0NWY3ZTM2NDk3M2JlMTlkMWFmOWY2MDlkNmJjYjg3MmZiMGMwYzAwZiJ9'
```