<template>
  <div class="wrap">
    <h1>5월 마지막주 영화 예매 순위</h1>
    <ul class="movies">
    </ul>
  </div>
</template>
<script>
export default {
  created () {
    this.$http.get('/api/movies')
        .then((response) => {
          this.movies = response.data
        })
  },
  data () {
    return {
      movies: []
    }
  }
}
</script>
