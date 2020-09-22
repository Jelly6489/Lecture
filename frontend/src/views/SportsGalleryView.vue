<template>
  <v-app id="inspire"><br>
    <div align="center">
      <sports-gall-form :items="boards"/>
    </div>
  </v-app>
</template>

<script>
import SportsGallForm from '@/components/SportsGallForm'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'SportsGalleryView',
  components: {
    SportsGallForm
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
