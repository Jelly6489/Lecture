import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import Test from '../views/Test.vue'
import Todo from '../views/Todo.vue'
import Concave from '../views/Concave.vue'

// For Cafe Board
import BoardListPage from '../views/BoardListPage.vue'
import BoardRegisterPage from '../views/BoardRegisterPage.vue'
import BoardModifyPage from '../views/BoardModifyPage.vue'
import BoardReadPage from '../views/BoardReadPage.vue'

// For Login System
import LoginPage from '../views/LoginPage.vue'
import AdminSetupPage from '../views/AdminSetupPage.vue'

// Vuetify
import VuetifyBoard from '../views/VuetifyBoard.vue'

// Vuetify Board List
import VuetifyBoardListPage from '../views/VuetifyBoardListPage.vue'

// For Crawling
import CrawlCategory from '../views/CrawlCategory.vue'

// Sports Gall
import SportsBoard from '../views/SportsBoard.vue'
import VueRegister from '../views/VueRegister.vue'
import VueLogin from '../views/VueLogin.vue'
import VueGall from '../views/VueGall.vue'
import VueListPage from '../views/VueListPage.vue'
import VueReadPage from '../views/VueReadPage.vue'
import VueModifyPage from '../views/VueModifyPage.vue'
import SportsRank from '../views/SportsRank.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: About
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    // component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/test',
    name: 'Test',
    component: Test
  },
  {
    path: '/todo',
    name: 'Todo',
    component: Todo
  },
  {
    path: '/concave',
    name: 'Concave',
    components: {
      default: Concave
    }
  },
  {
    path: '/board',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  },
  {
    path: '/board/created',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  },
  {
    path: '/board/:boardNoo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/board/:boardNo/editing',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      // 이 옵션을 설정하면 route.params가 컴포넌트의 props에 자동 설정됨
      default: true
    }
  },
  {
    path: '/LoginPage',
    name: 'LoginPage',
    components: {
      default: LoginPage
    }
  },
  {
    path: '/AdminSetupPage',
    name: 'AdminSetupPage',
    components: {
      default: AdminSetupPage
    }
  },
  {
    path: '/VuetifyBoard',
    name: 'VuetifyBoard',
    components: {
      default: VuetifyBoard
    }
  },
  {
    path: '/VuetifyBoardListPage',
    name: 'VuetifyBoardListPage',
    components: {
      default: VuetifyBoardListPage
    }
  },
  {
    path: '/CrawlCategory',
    name: 'CrawlCategory',
    components: {
      default: CrawlCategory
    }
  },
  {
    path: '/VueLogin',
    name: 'VueLogin',
    components: {
      default: VueLogin
    }
  },
  {
    path: '/VueRegister',
    name: 'VueRegister',
    components: {
      default: VueRegister
    }
  },
  {
    path: '/VueGall',
    name: 'VueGall',
    components: {
      default: VueGall
    }
  },
  {
    path: '/SportsBoard',
    name: 'SportsBoard',
    components: {
      default: SportsBoard
    }
  },
  {
    path: '/VueGall/create',
    name: 'VueListPage',
    components: {
      default: VueListPage
    }
  },
  {
    path: '/VueGall/:boardNo',
    name: 'VueReadPage',
    components: {
      default: VueReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/VueGall/:boardNo/editing',
    name: 'VueModifyPage',
    components: {
      default: VueModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/SportsRank',
    name: 'SportsRank',
    components: {
      default: SportsRank
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
