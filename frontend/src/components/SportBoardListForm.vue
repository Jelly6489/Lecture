<template>
  <div id="app" align="center">
    <v-responsive :max-height="670">
      <v-app id="inspire"><br>
        <v-app-bar
          app
          height="280px"
          src="@/assets/skateboard.png">
        <v-toolbar-title><p class="text-h1 font-weight-black">Sports</p></v-toolbar-title>
        </v-app-bar>

        <form @submit.prevent="submit">
        <v-card width="1000" height="620" color="#F9FBE7">
          <v-card-title>
            게시판
            <v-spacer></v-spacer>
            <v-text-field
              align="center"
              v-model="search"
              append-icon="mdi-magnify"
              label="Search"
              single-line
              hide-details
            ></v-text-field>
            <v-spacer></v-spacer>
          </v-card-title>
            <table border="1">
              <tr height="50">
                <th align="center" width="80" height="50">번호</th>
                <th align="center" width="500">제목</th>
                <th align="center" width="200">작성자</th>
                <th align="center" width="200">작성일</th>
              </tr>
              <tr v-if="!paginatedData || (Array.isArray(paginatedData) && paginatedData.length === 0)">
                <td colspan="4">
                  List is empty
                </td>
              </tr>
              <tr v-else v-for="page in paginatedData" :key="page.boardNo">
                <td>{{ page.boardNo }}</td>
                <td>
                  <router-link :to="{ name: 'VueReadPage',
                          params: { boardNo: page.boardNo.toString() } }">
                    {{ page.title }}
                  </router-link>
                </td>
                <td>{{ page.writer }}</td>
                <td>{{ page.regDate | moment('YYYY-MM-DD') }}</td>
              </tr>
            </table>
            <div class="btn-cover">
              <button :disabled="pageNum === 0"
                @click="prevPage" class="page-btn">
                ◀
              </button>
              <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
              <button :disabled="pageNum >= pageCount - 1"
                @click="nextPage" class="page-btn">
                ▶
             </button><br><br>
              <v-btn v-bind:style = "mystyle1" v-on:mouseover = "changebgcolor1" v-on:mouseout = "originalcolor1"
              class="mr-4" type="submit" :to="{ name: 'VueListPage' }">작성</v-btn>
              <v-btn dark v-bind:style = "mystyle2" v-on:mouseover = "changebgcolor2" v-on:mouseout = "originalcolor2"
              :to="{ name: 'SportsBoard' }">Back</v-btn>
            </div>
        </v-card><br>
        </form>
      </v-app>
    </v-responsive>
  </div>
</template>

<script>
import Vue from 'vue'
import vueMoment from 'vue-moment'
Vue.use(vueMoment)

export default {
  name: 'SportBoardListForm',
  data () {
    return {
      search: '',
      pageNum: 0,
      mystyle1: {
        backgroundColor: 'white'
      },
      mystyle2: {
        backgroundColor: 'black'
      }
    }
  },
  props: {
    listArray: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      default: 5
    },
    boards: {
      type: Array
    }
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
      this.mystyle2.backgroundColor = 'black'
    },
    nextPage () {
      this.pageNum += 1
    },
    prevPage () {
      this.pageNum -= 1
    },
    searchbar (e) {
      this.search = e.target.value

      if (this.search.length !== 0) {
        clearTimeout(this.debounce)
        this.debounce = setTimeout(() => {
          const filteredList = this.searchInfoList.filter(page => page.title.includes(this.search))
          this.page.title = filteredList
        }, 500)
      } else {
        clearTimeout(this.debounce)
        this.debounce = setTimeout(() => {
          this.page.title = []
        }, 500)
      }
    }
  },

  computed: {
    pageCount () {
      const listLen = this.listArray.length
      const listSize = this.pageSize

      let page = Math.floor(listLen / listSize)
      if (listLen % listSize > 0) {
        page += 1
      }

      return page
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize
      const end = start + this.pageSize
      return this.listArray.slice(start, end)
    }
  }
}
</script>
