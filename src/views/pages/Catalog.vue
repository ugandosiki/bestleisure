<template>
  <div class="catalog">
    <filter-menu-component v-if="filterMenu" />
    <q-icon
      :name="matReadMore"
      size="xl"
      class="filter-btn"
      :class="{ active_btn: filterMenu }"
      @click="filterMenu = !filterMenu"
    />
    <main class="catalog_content">
      <post-component v-for="post in posts" :key="post.id" />
      <q-pagination v-model="page" color="primary" size="16px" :max="pageCount" :direction-links="true" :max-pages="0" @input="pChangeHandler" class="q-pa-md"/>
    </main>
  </div>
</template>

<script>
import paginationMixin from "@/mixins/pagination.mixin";
import PostComponent from "../../components/pages/catalog/PostComponent.vue";
import FilterMenuComponent from "../../components/pages/catalog/FilterMenuComponent.vue";
import { matReadMore } from "@quasar/extras/material-icons";
export default {
  components: { PostComponent, FilterMenuComponent },
  name: "Catalog",
  mixins: [paginationMixin],
  data() {
    return {
      filterMenu: false,
      matReadMore: matReadMore,
    };
  },
  methods: {},
  async mounted() {
    this.initPagination(this.allPosts);
  },
};
</script>

<style scoped>
.catalog {
  display: flex;
  justify-content: center;
}
.catalog_content {
  margin: auto;
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: 50%;
  padding-top: 3%;
}
.filter-btn {
  transition-duration: 0.3s;
  cursor: pointer;
  position: fixed;
  right: 74.5%;
  top: 45%;
  transform: rotate(180deg);
}
.active_btn {
  transition-duration: 0.3s;
  transform: none;
}
@media (max-width: 600px) {
  .catalog_content {
    width: 90%;
    margin-top: 30px;
  }
}
</style>