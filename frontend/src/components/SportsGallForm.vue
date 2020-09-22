<template>
  <v-app id="inspire">
    <div align="center">
      <v-card width="1200" height="auto">
        <v-img src="@/assets/skateboard.png" max-height="310"></v-img>
        <v-card-title>
          게시판
          <v-spacer></v-spacer>
          <v-text-field
            v-model="search"
            append-icon="mdi-magnify"
            label="검색"
            single-line
            hide-details
            append-outer-icon
            outlined
            rounded
            color="#E65100"
          ></v-text-field>
        </v-card-title>
        <v-data-table :headers="headers" :items="items" :search="search" @click:row="titleClick">
          <template slot="items">
            <tr v-if="!items || (Array.isArray(items) && items.length === 0)">
              <td colspan="4">
                List is empty
              </td>
            </tr>

            <tr v-else v-for="board in items" :key="board.boardNo">
              <td align="center" >{{ board.boardNo }}</td>
              <td align="left">
                <router-link :to="{ name: 'BoardReadPage',
                        params: { boardNo: board.boardNo.toString() } }">
                  {{ board.title }}
                </router-link>
              </td>
              <td align="right">{{ board.writer }}</td>
              <td align="center">{{ board.regDate }}</td>
            </tr>
          </template>
        </v-data-table>
        <v-btn v-bind:style = "mystyle1" v-on:mouseover = "changebgcolor1" v-on:mouseout = "originalcolor1"
        class="mr-4" type="submit" :to="{ name: 'VueListPage' }">작성</v-btn>
        <v-btn dark v-bind:style = "mystyle2" v-on:mouseover = "changebgcolor2" v-on:mouseout = "originalcolor2"
        :to="{ name: 'SportsBoard' }">Back</v-btn><br><br>
      </v-card>
    </div>
  </v-app>
</template>

<script>
export default {
  name: 'SportsGallForm',
  data () {
    return {
      search: '',
      headers: [
        {
          text: '번호',
          align: 'start',
          sortable: false,
          value: 'boardNo',
        },
        { text: '제목', value: 'title' },
        { text: '작성자', value: 'writer' },
        { text: '작성일', value: 'regDate' }
      ],
      mystyle1: {
        backgroundColor: 'white'
      },
      mystyle2: {
        backgroundColor: 'black'
      }
    }
  },
  props: {
    items: Array
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
    titleClick (item) {
      this.$router.push({ name: 'VueReadPage', params: { boardNo: item.boardNo } })
    }
  }
}
</script>
<style>
  table {
    border: 2px solid #FFC107;
    border-radius: 3px;
    background-color: #fff;
  }
  th {
    background-color: #FFECB3;
    color: rgba(255, 255, 255, 0.66);
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -user-select: none;
  }
  td {
    background-color: #FFF8E1;
  }
</style>