<template>
  <div class="filter-menu shadow-2">
    <div class="filter-menu_title"><strong>Фильтры</strong></div>
    <div class="filter-menu_content">
      <q-select
        square
        filled
        v-model="filterData.category"
        :options="options"
        label="Страна"
        :option-value="
          (opt) => (Object(opt) === opt && 'id' in opt ? opt.id : null)
        "
        :option-label="
          (opt) =>
            Object(opt) === opt && 'name' in opt ? opt.name : '- Null -'
        "
      />
      <q-select
        square
        filled
        v-model="filterData.subcategory"
        :options="options"
        label="Город"
        :option-value="
          (opt) => (Object(opt) === opt && 'id' in opt ? opt.id : null)
        "
        :option-label="
          (opt) =>
            Object(opt) === opt && 'name' in opt ? opt.name : '- Null -'
        "
      />
      <q-select
        square
        filled
        v-model="filterData.type"
        :options="options"
        label="Тип заведения"
        :option-value="
          (opt) => (Object(opt) === opt && 'id' in opt ? opt.id : null)
        "
        :option-label="
          (opt) =>
            Object(opt) === opt && 'name' in opt ? opt.name : '- Null -'
        "
      />
      <q-select
        square
        filled
        v-model="filterData.likes"
        :options="options"
        label="Оценки"
        :option-value="
          (opt) => (Object(opt) === opt && 'id' in opt ? opt.id : null)
        "
        :option-label="
          (opt) =>
            Object(opt) === opt && 'name' in opt ? opt.name : '- Null -'
        "
      />
      <q-select
        square
        filled
        v-model="filterData.date"
        :options="options"
        label="Дата"
        :option-value="
          (opt) => (Object(opt) === opt && 'id' in opt ? opt.id : null)
        "
        :option-label="
          (opt) =>
            Object(opt) === opt && 'name' in opt ? opt.name : '- Null -'
        "
      />
    </div>
  </div>
</template>

<script>
export default {
  name: "FilterMenuComponent",
  data() {
    return {
         options: [{ name: "Украина" }, { name: "Россия" }],
         filterData:{
             category: null,
             subcategory: null,
             type: null,
             likes: null,
             date: null,
         }
    };
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
  height: 500px;
  background-color: #fff;
}
.filter-menu_title {
  font-size: 16pt;
}

.q-field{
    margin: 30px auto;
}
</style>