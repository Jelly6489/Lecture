<template>
  <div id="app" align="center">
    <v-card>
      <v-responsive :max-height="680">
        <v-app id="inspire"><br>
          <v-app-bar
            app
            height="300px"
            src="@/assets/skateboard.png">
          <v-toolbar-title><p class="text-h1 font-weight-black">게시판</p></v-toolbar-title>
          </v-app-bar><br>

          <form @submit.prevent="submit">
          <v-toolbar
            shaped
            dark
            dense
            floating>

            <input
            style="font-size:20pt; color:black; font-weight-bold; border: red 1px solid; background-color: white;"
            class="stage-search"
            type="text"
            placeholder="검색"
            @input="searchbar"
            @keydown.enter="KeydownEnter" />

            <v-btn type="submit" icon>
              <v-icon>mdi-magnify</v-icon>
            </v-btn>

            <v-btn icon>
              <v-icon>mdi-dots-vertical</v-icon>
            </v-btn>
          </v-toolbar><br><br>
            <table border="1">
              <tr height="50">
                <th align="center" width="80" height="50">No</th>
                <th align="center" width="500">Title</th>
                <th align="center" width="200">Writer</th>
                <th align="center" width="200">Registration Date</th>
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
                <td>{{ page.regDate }}</td>
              </tr>
            </table>
            <div class="btn-cover">
              <button :disabled="pageNum === 0"
                @click="prevPage" class="page-btn">
                이전
              </button>
              <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
              <button :disabled="pageNum >= pageCount - 1"
                @click="nextPage" class="page-btn">
                다음
              </button><br><br>
              <v-btn class="mr-4" type="submit" :to="{ name: 'VueListPage' }">작성</v-btn>
              <v-btn :to="{ name: 'SportsBoard' }">Back</v-btn>
            </div>
          </form>
        </v-app>
      </v-responsive>
    </v-card>
  </div>
</template>

<script>
export default {
  name: 'SportBoardListForm',
  data () {
    return {
      pageNum: 0
    }
  },
  props: {
    listArray: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      required: true,
      default: 5
    },
    boards: {
      type: Array
    }
  },
  methods: {
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
