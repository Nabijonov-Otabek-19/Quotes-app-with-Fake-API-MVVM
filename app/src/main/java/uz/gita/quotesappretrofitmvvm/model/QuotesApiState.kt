package uz.gita.quotesappretrofitmvvm.model

sealed class QuotesApiState<T: Any> {
    class Success<T>()
}
