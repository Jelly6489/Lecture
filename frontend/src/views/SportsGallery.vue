<template>
  <div align="center">
    <sports-gallery-form :list-array="pageArray"/>
  </div>
</template>

<script>
import axios from 'axios'
import SportsGalleryForm from '@/components/SportsGalleryForm.vue'

export default {
  name: 'SportsGallery',
  components: {
    SportsGalleryForm
  },
  data () {
    return {
      pageArray: []
    }
  },
  created () {
    axios.get('http://localhost:7777/boards')
      .then(res => {
        console.log(res)
        this.pageArray = res.data
      })
      .catch(err => {
        console.log(err)
      })
  }
}
</script>
