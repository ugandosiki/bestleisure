<template>
  <main class="catalog">
    <filter-menu-component
      v-if="filterMenu"
      :allPosts="allPosts"
      @find="onFind($event)"
    />
    <q-icon
      :name="matReadMore"
      size="xl"
      class="filter-btn"
      :class="{ active_btn: filterMenu }"
      @click="filterMenu = !filterMenu"
    />

    <div class="q-pa-md row q-gutter-xl catalog_content">
      <post-component v-for="post in posts" :key="post.id" :postData="post" />

      <q-pagination
        v-model="page"
        color="primary"
        size="16px"
        :max="pageCount"
        :direction-links="true"
        :max-pages="0"
        @input="pChangeHandler"
        class="pagination"
      />
    </div>
  </main>
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
      filterMenu: true,
      matReadMore: matReadMore,
    };
  },
  methods: {
    onFind(data) {
      console.log("child component said", data);
      let backupData = this.fetchedPosts;
      if (
        data.category == null &&
        data.subCategory == null &&
        data.type == null &&
        data.like == null
      ) {
        this.allPosts = backupData;
        this.initPagination(this.allPosts);
      }
      if (data.category != null) {
        this.allPosts = this.fetchedPosts.filter(
          (e) => e.category.name == data.category.name
        );
        this.initPagination(this.allPosts);
      }
      if (data.subCategory != null) {
        this.allPosts = this.fetchedPosts.filter(
          (e) => e.subCategory.name == data.subCategory.name
        );
        console.log("all posts", this.allPosts);
        this.initPagination(this.allPosts);
      }
      if (
        data.type !== null &&
        data.category !== null &&
        data.subCategory !== null
      ) {
        this.allPosts = this.fetchedPosts.filter(
          (e) =>
            e.type.name == data.type.name &&
            e.category.name == data.category.name &&
            e.subCategory.name == data.subCategory.name
        );
        console.log("all posts", this.allPosts);
        this.initPagination(this.allPosts);
      }
      if (
        data.type !== null &&
        data.category == null &&
        data.subCategory == null
      ) {
        this.allPosts = this.fetchedPosts.filter(
          (e) => e.type.name == data.type.name
        );
        console.log("all posts", this.allPosts);
        this.initPagination(this.allPosts);
      }
      if (
        data.type !== null &&
        data.category !== null 
      ) {
        this.allPosts = this.fetchedPosts.filter(
          (e) =>
            e.type.name == data.type.name &&
            e.category.name == data.category.name
        );
        console.log("all posts", this.allPosts);
        this.initPagination(this.allPosts);
      }
      if (
        data.type !== null &&
        data.category !== null &&
        data.subCategory !== null &&
        data.like.id == 1
      ) {
        this.allPosts.sort(function (a, b) {
          return a.userLikes.length - b.userLikes.length;
        });
        console.log("all posts", this.allPosts);
        this.initPagination(this.allPosts);
      }
      if (
        data.like.id == 1 &&
        data.type == null &&
        data.type == null &&
        data.category == null
      ) {
        this.allPosts = this.fetchedPosts.sort(function (a, b) {
          console.log(a.userLikes.length - b.userLikes.length);
          return a.userLikes.length - b.userLikes.length;
        });
        console.log("like", data.like);
        this.initPagination(this.allPosts);
      }
      if (
        data.like.id == 2 &&
        data.type == null &&
        data.type == null &&
        data.category == null
      ) {
        this.allPosts = this.fetchedPosts.sort(function (a, b) {
          return b.userLikes.length - a.userLikes.length;
        });
        console.log("like", data.like);
        this.initPagination(this.allPosts);
      }
      if (
        data.type !== null &&
        data.category !== null &&
        data.subCategory !== null &&
        data.like.id == 2
      ) {
        this.allPosts.sort(function (a, b) {
          return b.userLikes.length - a.userLikes.length;
        });
        console.log("all posts", this.allPosts);
        this.initPagination(this.allPosts);
      }
    },
  },
  mounted() {
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
  display: flex;
  flex-direction: column;
  width: 50%;
  margin-top: 1%;
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
.pagination {
  background: white;
  width: 99%;
  margin-top: 130px;
}
@media (max-width: 1024px) {
  .catalog_content {
    width: 90%;
    margin-top: 30px;
  }
}
</style>