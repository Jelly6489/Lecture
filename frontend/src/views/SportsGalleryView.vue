<template>
  <div id="items">
    <h2>게시판</h2>
    <router-link :to="{ name: 'VueListPage' }">
      작성
    </router-link>
    <sports-gallery-form :items="boards"/>
  </div>
</template>

<script>
import SportsGalleryForm from '@/components/SportsGalleryForm'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'SportsGalleryView',
  components: {
    SportsGalleryForm
  },
  computed: {
    ...mapState(['boards'])
  },
  mounted () {
    this.fetchBoardList()
  },
  methods: {
    ...mapActions(['fetchBoardList'])
  }
}

</script>
