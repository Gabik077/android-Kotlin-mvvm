package com.cursoandroidm2.screens.perfilinstagram.models

data class UserInstagram(
    val username: String,
    val profileImageUr: String,
    val posts: Int,
    val followers: Int,
    val following: Int,
    val name: String,
    val description: String?,//null safety , puede ser nulo
    val stories: List<Story>
)

data class Story(
    val storyImage: String,
    val storyTitle: String
)

object UserInstagramObject { // datos de prueba , deberia venir del backend
    val user = UserInstagram(
        username = "Gabik077",
        description = "I am a software engineer",
        followers = 100,
        following = 200,
        posts = 300,
        name = "Gabriel Cabrera",
        profileImageUr = "https://avatars.githubusercontent.com/u/11892086?v=4",
        stories = listOf(
            Story(
                storyImage = "https://picsum.photos/600/600?random=1",
                storyTitle = "Story 1"
            ),
            Story(
                storyImage = "https://picsum.photos/600/600?random=2",
                storyTitle = "Story 2"
            ),
            Story(
                storyImage = "https://picsum.photos/600/600?random=3",
                storyTitle = "Story 3"
            ),
            Story(
                storyImage = "https://picsum.photos/600/600?random=4",
                storyTitle = "Story 4"
            ),
            Story(
                storyImage = "https://picsum.photos/600/600?random=5",
                storyTitle = "Story 5"
            ),
            Story(
                storyImage = "https://picsum.photos/600/600?random=6",
                storyTitle = "Story 6"
            ),
            Story(
                storyImage = "https://picsum.photos/600/600?random=7",
                storyTitle = "Story 7"
            ),
            Story(
                storyImage = "https://picsum.photos/600/600?random=8",
                storyTitle = "Story 8"
            ),
            Story(
                storyImage = "https://picsum.photos/600/600?random=9",
                storyTitle = "Story 9"
            ),
            Story(
                storyImage = "https://picsum.photos/600/600?random=10",
                storyTitle = "Story 10"
            ),
        )
    )

    val userPhotos = List(30) {
        Photo(url = "https://picsum.photos/300/300?random=$it")
    }
}

data class Photo(val url: String)