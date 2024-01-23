import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AboutViewVue from '@/views/AboutView.vue'
import Note from '@/views/Note.vue'
import EditNoteView from '@/views/EditNoteView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    name: "Noter, easy way of sharing notes"
  },
  {
    path: '/about',
    name: 'about',
    component: AboutViewVue,
    name: "Noter - about"
  },
  {
    path: '/note/:slug',
    name: 'note',
    component: Note,
    name: "Noter - your note"
  },
  {
    path: '/note/:slug/edit',
    name: 'editNote',
    component: EditNoteView,
    name: "Noter - edit your note"
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

router.beforeEach((to, from, next) => {
  document.title = to.name;
  next();
});

export default router
