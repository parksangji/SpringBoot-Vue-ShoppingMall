<template>
  <Header/>
  <router-view></router-view>
  <Footer/>
</template>

<script>
import Header from './components/common/header.vue';
import Footer from './components/common/footer.vue';
export default {
    name: "App",
    components: { Header, Footer }
}
</script>
