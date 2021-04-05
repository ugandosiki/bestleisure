<template>
  <div class="filter-menu shadow-2">
    <div class="filter-menu_title"><strong>Фильтры</strong></div>
    <div class="filter-menu_content">
      <q-select
        @input="find()"
        square
        filled
        v-model="filterData.category"
        :options="categoryOptions"
        label="Страна"
        option-value="id"
        option-label="name"
        map-options
      />
      <q-select
        @input="find()"
        square
        filled
        v-model="filterData.subcategory"
        :options="subCategoryOptions"
        label="Город"
        option-value="id"
        option-label="name"
        map-options
      />
      <q-select
        @input="find()"
        square
        filled
        v-model="filterData.type"
        :options="typeOptions"
        label="Тип заведения"
        option-value="id"
        option-label="name"
        map-options
      />
      <q-select
        @input="find()"
        square
        filled
        v-model="filterData.like"
        :options="options.likeOptions"
        label="Оценки"
        option-value="id"
        option-label="name"
        map-options
      />

      <q-btn label="Сбросить фильтры" stretch color="primary" @click="discardFilter" />
    </div>
  </div>
</template>

<script>
export default {
  name: "FilterMenuComponent",
  data() {
    return {
      options: {
        likeOptions: [
          { id: 1, name: "по возрастанию" },
          { id: 2, name: "по убыванию" },
        ],
      },
      filterData: {
        category: null,
        subcategory: null,
        type: null,
        like: null,
      },
    };
  },
  computed: {
    categoryOptions() {
      let categoriesData = this.$store.state.category.categories;
      let categoryOptions = [];
      categoriesData.forEach((element) => {
        categoryOptions.push(element);
      });
      console.log(categoryOptions);
      return categoryOptions;
    },
    subCategoryOptions() {
      if (this.filterData.category != null) {
        let subCategoriesData = this.$store.state.category.categories;
        let subCats = [];
        let curSubCategoryOptions = [];
        subCategoriesData.forEach((e) => {
          if(e.id == this.filterData.category.id){
            subCats.push(e);
          }
        subCats.forEach(e => curSubCategoryOptions = e.subCategories)
        });
        console.log("subCategoryOptions ", curSubCategoryOptions);
        return curSubCategoryOptions;
      }
    },
    typeOptions() {
      let typesData = this.$store.state.type.types;
      let typeOptions = [];
      typesData.forEach((element) => {
        typeOptions.push(Object.freeze(element));
      });
      return typeOptions;
    },
  },
  methods: {
    find() {
      console.log("find success");
      this.$emit("find", {
        category: this.filterData.category,
        subCategory: this.filterData.subcategory,
        type: this.filterData.type,
        like: this.filterData.like,
      });
    },
    discardFilter() {
      this.filterData.subcategory = null;
      this.filterData.category = null;
      this.filterData.like = null;
      this.filterData.type = null;
      this.find();
    },
  },
};
</script>

<style scoped>
.filter-menu {
  position: fixed;
  top: 22%;
  right: 77%;
  text-align: center;
  width: 300px;
  height: 450px;
  background-color: #fff;
}
.filter-menu_title {
  font-size: 16pt;
}

.q-field {
  margin: 30px auto;
}
</style>