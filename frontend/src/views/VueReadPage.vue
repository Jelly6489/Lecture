<template>
  <div align="center">
    <v-app id="inspire">
      <form>
        <v-card width="1000" color="#E0F2F1">
          <v-img src="@/assets/back1.png" max-height="310"></v-img>
          <vue-list-read-form v-if="board" :board="board"/>
          <v-btn v-bind:style = "mystyle1" v-on:mouseover = "changebgcolor1" v-on:mouseout = "originalcolor1"
          class="mr-4" type="submit" :to="{ name: 'VueModifyPage', params: { boardNo } }">수정</v-btn>
          <v-btn v-bind:style = "mystyle2" v-on:mouseover = "changebgcolor2" v-on:mouseout = "originalcolor2"
          class="mr-4" @click="onDelete">삭제</v-btn>
          <v-btn dark v-bind:style = "mystyle3" v-on:mouseover = "changebgcolor3" v-on:mouseout = "originalcolor3"
          :to="{ name: 'SportsGalleryView' }">Back</v-btn><br><br>
        </v-card>
      </form>
    </v-app>
  </div>
</template>

<script>
import VueListReadForm from '@/components/VueListReadForm'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
  name: 'VueReadPage',
  props: {
    boardNo: {
      required: true
    }
  },
  data () {
    return {
      mystyle1: {
        backgroundColor: 'white'
      },
      mystyle2: {
        backgroundColor: 'white'
      },
      mystyle3: {
        backgroundColor: 'black'
      }
    }
  },
  components: {
    VueListReadForm
  },
  computed: {
    ...mapState([
      'board'
    ])
  },
  mounted () {
    console.log('VueReadPage created(): ' + this.boardNo)
    this.fetchBoard(this.boardNo)
      .catch(err => {
        alert(err.response.data.message)
        this.$router.push()
      })
  },
  methods: {
    changebgcolor1: function () {
      this.mystyle1.backgroundColor = '#81D4FA'
    },
    originalcolor1: function () {
      this.mystyle1.backgroundColor = 'white'
    },
    changebgcolor2: function () {
      this.mystyle2.backgroundColor = '#81D4FA'
    },
    originalcolor2: function () {
      this.mystyle2.backgroundColor = 'white'
    },
    changebgcolor3: function () {
      this.mystyle3.backgroundColor = '#81D4FA'
    },
    originalcolor3: function () {
      this.mystyle3.backgroundColor = 'black'
    },
    ...mapActions([
      'fetchBoard'
    ]),
    onDelete () {
      const { boardNo } = this.board
      axios.delete(`http://localhost:7777/boards/${boardNo}`)
        .then(res => {
          res
          alert('Delete Success')
          this.$router.push({ name: 'SportsGalleryView' })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    }
  }
}
</script>
