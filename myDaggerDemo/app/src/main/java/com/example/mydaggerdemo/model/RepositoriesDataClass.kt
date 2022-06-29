package com.example.mydaggerdemo.model

data class RepositoriesDataClass(val items: List<ReposDataList>)
data class ReposDataList(val name: String? , val description: String?, val owner: Owner?)
data class Owner(val avatar_url: String?)
