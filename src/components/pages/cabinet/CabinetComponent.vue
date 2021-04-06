<template>
  <div class="cabinet">
    <div class="cabinet_content">
      <div class="user">
        <div class="user-info shadow-2 q-mt-sm q-mt-md q-ml-sm">
          <div class="user-info_title">
            <h6>Информация о пользователе</h6>
          </div>
          <div class="user-info_content">
            Имя(ник):
            <strong>{{ $store.state.auth.user.name }}</strong>
            Почтовый адрес:
            <strong>{{ $store.state.auth.user.email }}</strong>
            Город:
            <strong>{{ $store.state.auth.user.city }}</strong>
          </div>
        </div>
        <div class="user-actions shadow-2 q-mt-sm q-mt-md q-ml-sm">
          <div class="user-actions_title">
            <h6>Действия c аккаунтом</h6>
          </div>
          <div class="user-actions_content">
            <button class="action-btn shadow-2 q-pa-sm">Изменить пароль</button>
            <button class="action-btn shadow-2 q-pa-sm">Изменить город</button>
            <button
              class="action-btn shadow-2 q-pa-sm"
              @click="$store.dispatch('auth/logout')"
            >
              Выйти с аккаунта
            </button>
          </div>
        </div>
      </div>

      <div class="posts-actions shadow-2">
        <h6>Действия с записями</h6>

        <div class="button-panel">
          <q-btn-group>
            <q-btn
              color="teal-6"
              icon="add"
              label="Добавить новую запись"
              size="12px"
              @click="openCreateNewPost = true"
            />
            <q-btn
              color="teal-6"
              icon="add"
              label="Добавить новую страну"
              size="12px"
              @click="openCreateNewCategory = true"
            />
            <q-btn
              color="teal-6"
              icon="add"
              label="Добавить новый город"
              size="12px"
              @click="openCreateNewSubCategory = true"
            />
            <q-btn
              color="red"
              icon="delete"
              label="Удалить запись"
              @click="openDeletePost = true"
              size="12px"
            />
          </q-btn-group>
          <hr />
          <h6>Ваши записи</h6>
          <div class="posts-content">
            <user-post-component
              class="shadow-0"
              v-for="post in userPosts"
              :key="post.id"
              :post="post"
            />
          </div>
        </div>
      </div>
    </div>

    <q-dialog
      ref="dialog"
      v-model="openCreateNewPost"
      transition-show="scale"
      transition-hide="scale"
      square
    >
      <div class="form-div q-pa-md">
        <q-form
          class="q-gutter-md"
          @submit.prevent="createNewPost()"
          method="post"
          enctype="multipart/form-data"
        >
          <q-input
            filled
            v-model="post.title"
            square
            outlined
            label="Название*"
            hint="Введите название"
            lazy-rules
            name="title"
            :rules="[
              (val) => (val && val.length > 0) || 'Please type something',
            ]"
          />
          <span class="e-label">Введите описание*</span>
          <q-editor
            v-model="post.description"
            :dense="$q.screen.lt.xl"
            :toolbar="[
              [
                {
                  label: 'ВЫРАВНИВАНИЕ',
                  icon: $q.iconSet.editor.align,
                  fixedLabel: true,
                  options: ['left', 'center', 'right', 'justify'],
                },
              ],
              [
                'bold',
                'italic',
                'strike',
                'underline',
                'subscript',
                'superscript',
              ],
              ['token', 'hr', 'link', 'custom_btn'],
              ['print', 'fullscreen'],
              [
                {
                  label: 'ЗАГОЛОВКИ',
                  icon: $q.iconSet.editor.formatting,
                  list: 'no-icons',
                  options: ['p', 'h1', 'h2', 'h3', 'h4', 'h5', 'h6'],
                },
                {
                  label: 'РАЗМЕР ТЕКСТА',
                  icon: $q.iconSet.editor.fontSize,
                  fixedLabel: true,
                  fixedIcon: true,
                  list: 'no-icons',
                  options: [
                    'size-1',
                    'size-2',
                    'size-3',
                    'size-4',
                    'size-5',
                    'size-6',
                    'size-7',
                  ],
                },
                {
                  label: 'СТИЛЬ ТЕКСТА',
                  icon: $q.iconSet.editor.font,
                  fixedIcon: true,
                  list: 'no-icons',
                  options: [
                    'default_font',
                    'arial',
                    'arial_black',
                    'comic_sans',
                    'courier_new',
                    'impact',
                    'lucida_grande',
                    'times_new_roman',
                    'verdana',
                  ],
                },
                'removeFormat',
              ],
              ['quote', 'unordered', 'ordered', 'outdent', 'indent'],

              ['undo', 'redo'],
              ['viewsource'],
            ]"
            :fonts="{
              arial: 'Arial',
              arial_black: 'Arial Black',
              comic_sans: 'Comic Sans MS',
              courier_new: 'Courier New',
              impact: 'Impact',
              lucida_grande: 'Lucida Grande',
              times_new_roman: 'Times New Roman',
              verdana: 'Verdana',
            }"
          />
          <q-file
            color="dark-12"
            v-model="image"
            label="Выберите фотографию вашего заведения"
            counter
            name="file"
            max-files="1"
            style="min-width: 365px; max-width: 97%"
          >
            <template v-slot:prepend>
              <q-icon name="attach_file" />
            </template>
          </q-file>

          <q-input bottom-slots v-model="post.address" label="Адрес заведения">
            <template v-slot:prepend>
              <q-icon name="place" />
            </template>

            <template v-slot:hint>
              Введите полный адрес вашего заведения(Украина, г. Киев, ул.
              Чкаловская 4А)
            </template>
          </q-input>
          <q-select
            square
            outlined
            name="type"
            v-model="post.type"
            :options="typeOptions"
            option-value="id"
            option-label="name"
            emit-value
            map-options
            label="Выберите тип заведения"
          />
          <q-select
            square
            outlined
            name="category"
            v-model="post.category"
            :options="categoryOptions"
            option-value="id"
            option-label="name"
            emit-value
            map-options
            label="Выберите страну"
          />
          <q-select
            square
            outlined
            name="subCategory"
            v-model="post.subCategory"
            :options="subCategoryOptions"
            option-value="id"
            option-label="name"
            emit-value
            map-options
            label="Выберите город"
          />
          <div>
            <q-btn label="Создать страницу" type="submit" color="primary" />
          </div>
        </q-form>
      </div>
    </q-dialog>

    <q-dialog
      ref="dialog"
      v-model="openCreateNewCategory"
      transition-show="scale"
      transition-hide="scale"
      square
    >
      <div class="form-div q-pa-md">
        <q-form
          class="q-gutter-md"
          @submit.prevent="createNewCategory()"
          method="post"
          enctype="multipart/form-data"
        >
          <q-input
            filled
            v-model="category.name"
            square
            outlined
            label="Название*"
            hint="Введите название страны"
            lazy-rules
            name="name"
            :rules="[
              (val) => (val && val.length > 0) || 'Please type something',
            ]"
          />
          <div>
            <q-btn
              label="Добавить новую страну"
              type="submit"
              color="primary"
            />
          </div>
        </q-form>
      </div>
    </q-dialog>

    <q-dialog
      ref="dialog"
      v-model="openCreateNewSubCategory"
      transition-show="scale"
      transition-hide="scale"
      square
    >
      <div class="form-div q-pa-md">
        <q-form
          class="q-gutter-md"
          @submit.prevent="createNewSubCategory()"
          method="post"
          enctype="multipart/form-data"
        >
          <q-input
            filled
            v-model="subcategory.name"
            square
            outlined
            label="Название*"
            hint="Введите название города"
            lazy-rules
            name="name"
            :rules="[
              (val) => (val && val.length > 0) || 'Please type something',
            ]"
          />
          <q-select
            square
            outlined
            name="category"
            v-model="subcategory.category"
            :options="categoryOptions"
            option-value="id"
            option-label="name"
            emit-value
            map-options
            label="Выберите страну"
          />
          <div>
            <q-btn label="Добавить новый город" type="submit" color="primary" />
          </div>
        </q-form>
      </div>
    </q-dialog>

    <q-dialog
      ref="dialog"
      v-model="openDeletePost"
      transition-show="scale"
      transition-hide="scale"
      square
    >
      <div class="form-div q-pa-md">
        <q-form
          class="q-gutter-md"
          @submit.prevent="deletePost()"
          method="post"
          enctype="multipart/form-data"
        >
          <q-input
            filled
            v-model="deleteTitle"
            square
            outlined
            label="Название*"
            hint="Введите название, по которому хотите удалить запись"
            lazy-rules
            name="title"
            :rules="[
              (val) => (val && val.length > 0) || 'Please type something',
            ]"
          />
          <div>
            <q-btn label="Удалить" type="submit" color="primary" />
          </div>
        </q-form>
      </div>
    </q-dialog>
  </div>
</template>

<script>
import Post from "@/models/post";
import Category from "@/models/category";
import SubCategory from "@/models/subcategory";
import UserPostComponent from "../cabinet/UserPostComponent.vue";
export default {
  name: "CabinetComponent",
  components: { UserPostComponent },
  data() {
    return {
      openDeletePost: false,
      openCreateNewSubCategory: false,
      openCreateNewPost: false,
      openCreateNewCategory: false,
      post: new Post("", "", "", "", "", "", ""),
      category: new Category(""),
      subcategory: new SubCategory("", ""),
      image: [],
      deleteTitle: "",
    };
  },
  computed: {
    userPosts() {
      let userPosts = this.$store.state.post.posts;
      userPosts.map((e, index, array) => {
        if (e.user.email !== this.$store.state.auth.user.email) {
          array.splice(index, 1);
        }
      });
      console.log(userPosts);
      return userPosts;
    },
    categoryOptions() {
      let categoriesData = this.$store.state.category.categories;
      let categoryOptions = [];
      categoriesData.forEach((element) => {
        categoryOptions.push(Object.freeze(element));
      });
      return categoryOptions;
    },
    subCategoryOptions() {
      let subCategoriesData = this.$store.state.subcategory.subcategories;
      let subCategoryOptions = [];
      subCategoriesData.forEach((element) => {
        subCategoryOptions.push(Object.freeze(element));
      });
      return subCategoryOptions;
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
    createNewPost() {
      console.log(this.post.category);
      console.log(this.post.title);
      console.log(this.image);
      let data = {
        p: this.post,
        i: this.image,
        u: this.$store.state.auth.user.id,
      };
      this.$store.dispatch("post/create", { data });
      this.$refs.dialog.hide();
    },
    createNewCategory() {
      this.$store.dispatch("category/create", this.category);
      this.$refs.dialog.hide();
    },
    createNewSubCategory() {
      this.$store.dispatch("subcategory/create", this.subcategory);
      this.$refs.dialog.hide();
    },
    deletePost() {
      const up = this.userPosts;
      const even = (e) => e.title == this.deleteTitle;
      if (up.some(even)) {
        this.$store.dispatch("post/delete", this.deleteTitle);
        this.$refs.dialog.hide();
      } else {
        alert("Вы не являетесь владельцем данной записи");
      }
    },
  },
};
</script>

<style scoped>
.e-label {
  position: relative;
  color: #5c5c5c;
  left: 10px;
  top: 10px;
}
.cabinet {
  display: flex;
  justify-content: center;
}
.form-div {
  margin: auto;
  width: 100%;
  background-color: rgba(255, 255, 255, 1);
}
h6 {
  margin-bottom: 10px;
  text-align: center;
  margin-top: 20px;
}
.cabinet_content {
  border-radius: 3px;
  background: rgba(255, 255, 255, 0.9);
  margin: 3% auto;
  display: flex;
  flex-direction: column;
  width: 50%;
}
.user {
  width: 100%;
  margin: auto;
  display: flex;
  flex-direction: row;
}
.user-info {
  padding: 10px;
  width: 48%;
  display: flex;
  flex-direction: column;
}
.user-info_content {
  display: flex;
  flex-direction: column;
  color: #656565;
}
.user-info_content strong {
  color: black;
}
.user-actions {
  width: 49%;
  padding: 10px;
}
.user-actions_content {
  display: flex;
  flex-direction: column;
}
.action-btn {
  border-radius: 3px;
  color: white;
  margin-top: 10px;
  cursor: pointer;
  background-color: #07a7a7;
  border: none;
}
.action-btn:hover {
  transition-duration: 0.3s;
  background-color: #0080e3;
}
.button-panel {
  padding: 10px;
  text-align: center;
}
.posts-actions {
  margin: 20px auto;
  width: 97%;
}
</style>