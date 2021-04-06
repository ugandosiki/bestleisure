<template>
  <div class="post">
    <span
      class="user-menu fixed-left"
      v-if="
        postData.user.role.name == 'ROLE_OWNER' &&
        postData.user.email == $store.state.auth.user.email
      "
    >
      <q-btn
        icon="widgets"
        color="primary"
        style="border-radius: 0px"
        @click="open('left')"
      />
    </span>
    <q-dialog v-model="dialog" :position="position">
      <q-card style="width: 200px">
        <q-card-section class="row">
          <div class="btns">
            <q-btn
              label="Добавить рекламу"
              color="teal"
              style="border-radius: 0px"
              @click="bannerDialogAdd = true"
            />
            <q-dialog
              ref="dialog"
              v-model="bannerDialogAdd"
              transition-show="scale"
              transition-hide="scale"
            >
              <div class="form-div q-pa-md">
                <q-form
                  class="q-gutter-md"
                  @submit.prevent="addBanner()"
                  method="post"
                  enctype="multipart/form-data"
                >
                  <q-input
                    filled
                    v-model="banner.title"
                    square
                    outlined
                    label="Название*"
                    hint="Введите название акции"
                    lazy-rules
                    name="title"
                    :rules="[
                      (val) =>
                        (val && val.length > 0) || 'Please type something',
                    ]"
                  />
                  <div>
                    <q-input
                      v-model="banner.description"
                      filled
                      square
                      outlined
                      autogrow
                      label="Описание*"
                      hint="Введите описание"
                      name="description"
                      lazy-rules
                      :rules="[
                        (val) =>
                          (val && val.length > 0) || 'Please type something',
                      ]"
                    />

                    <q-file
                      color="dark-12"
                      v-model="bannerImage"
                      label="Выберите изображения для баннера"
                      counter
                      name="file"
                      max-files="1"
                      style="min-width: 365px; max-width: 97%"
                    >
                      <template v-slot:prepend>
                        <q-icon name="attach_file" />
                      </template>
                    </q-file>
                    <q-btn
                      label="Добавить баннер"
                      type="submit"
                      color="primary"
                    />
                  </div>
                </q-form>
              </div>
            </q-dialog>
            <q-btn
              label="Редактировать описание"
              color="teal"
              style="border-radius: 0px"
              @click="postDialogDescr = true"
            />
            <q-dialog
              ref="dialog"
              full-width
              v-model="postDialogDescr"
              transition-show="scale"
              transition-hide="scale"
            >
              <div class="form-div q-pa-md">
                <q-form
                  class="q-gutter-md"
                  @submit.prevent="updateDescr()"
                  method="put"
                  enctype="multipart/form-data"
                >
                  <div>
                    <q-editor
              
                      v-model="postDescription"
                      toolbar-bg="primary"
                      toolbar-text-color="white"
                      toolbar-toggle-color="black"
                      :dense="$q.screen.lt.md"
                      :toolbar="[
                        [
                          {
                            label: 'ВЫРАВНИВАНИЕ',
                            icon: $q.iconSet.editor.align,
                            fixedLabel: true,
                            list: 'only-icons',
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
                    <q-btn
                      class="q-ma-sm"
                      label="Изменить описание"
                      type="submit"
                      color="primary"
                    />
                  </div>
                </q-form>
              </div>
            </q-dialog>
            <q-btn
              label="Изменить название"
              color="teal"
              style="border-radius: 0px"
              @click="postDialogTitle = true"
            />
            <q-dialog
              ref="dialog"
              v-model="postDialogTitle"
              transition-show="scale"
              transition-hide="scale"
            >
              <div class="form-div q-pa-md">
                <q-form
                  class="q-gutter-md"
                  @submit.prevent="updateTitle()"
                  method="put"
                  enctype="multipart/form-data"
                >
                  <div>
                    <q-input
                      v-model="postTitle"
                      filled
                      square
                      outlined
                      autogrow
                      label="Название*"
                      hint="Введите новое название"
                      name="title"
                      lazy-rules
                      :rules="[
                        (val) =>
                          (val && val.length > 0) || 'Please type something',
                      ]"
                    />
                    <q-btn
                      label="Изменить название"
                      type="submit"
                      color="primary"
                    />
                  </div>
                </q-form>
              </div>
            </q-dialog>
            <q-btn
              label="Сменить изображение"
              color="teal"
              style="border-radius: 0px"
              @click="open('left')"
            />
          </div>
        </q-card-section>
      </q-card>
    </q-dialog>
    <div class="post_content shadow-4">
      <div class="q-col-gutter-md row items-start">
        <div class="col-12">
          <div>
            <q-parallax :height="300" :speed="0.7">
              <template v-slot:media>
                <img :src="src + postImage.path" />
              </template>
              <div class="absolute-bottom text-subtitle3 text-center">
                <div class="post-title">{{ postData.title }}</div>
              </div>
              <q-btn
                class="absolute-left"
                icon="favorite"
                :label="postData.userLikes.length"
                color="primary"
                style="border-radius: 0px; height: 35px"
                @click="addLike()"
              />
              <br />
              <q-chip
                class="absolute-left"
                color="primary"
                text-color="white"
                icon="place"
                square
                style="
                  border-radius: 0px;
                  margin-left: 0px;
                  top: 45px;
                  font-size: 11.5pt;
                "
              >
                {{ postData.address }}
              </q-chip>
            </q-parallax>
          </div>
        </div>
      </div>
      <div class="post-descr">
        <span class="descr-title">О ЗАВЕДЕНИИ</span><br />
        <p v-html="description">{{ description }}</p>
      </div>
      <div class="post-banners">
        <span class="banner-title">АКЦИИ</span><br />
        <div class="banners-content">
          <banner-component
            class="banner"
            v-for="banner in postData.banners"
            :key="banner.id"
            :banner="banner"
          />
          <div class="empty-banners" v-if="postData.banners.length == 0">
            <p class="text-center">У этого заведения пока что нет акций</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Banner from "@/models/banner";
import BannerComponent from "../../components/pages/catalog/BannerComponent.vue";
export default {
  components: { BannerComponent },
  name: "PostPage",
  data() {
    return {
      src: "http://localhost:8080/uploads/",
      dialog: false,
      position: "left",
      postDialogDescr: false,
      bannerDialogAdd: false,
      postDialogTitle: false,
      banner: new Banner("", "", ""),
      bannerImage: [],
      menuVisible: false,
      postDescription: "",
      postTitle: "",
      description: "",
    };
  },
  computed: {
    postData() {
      let posts = this.$store.state.post.posts;
      let post = {};
      posts.forEach((e) => {
        if (e.id == this.$route.params.id) {
          post = e;
        }
      });
      this.postDescription = post.description;
      this.description = post.description;
      return post;
    },
    postImage() {
      let postImage = {};
      this.postData.images.forEach((e) => {
        if (e.path.match(/Post/g)) {
          postImage = e;
          console.log(postImage);
        }
      });
      return postImage;
    },
  },
  methods: {
    open(position) {
      this.position = position;
      this.dialog = true;
    },
    addBanner() {
      console.log(this.banner);
      let data = {
        b: this.banner,
        i: this.bannerImage,
        p: this.postData.id,
      };
      this.$store.dispatch("banner/create", { data });
      this.$refs.dialog.hide();
    },
    updateDescr() {
      let data = {
        i: this.postData.id,
        d: this.postDescription,
      };
      this.$store.dispatch("post/updateDescr", { data });
      this.$refs.dialog.hide();
    },
    updateTitle() {
      let data = {
        i: this.postData.id,
        t: this.postTitle,
      };
      this.$store.dispatch("post/updateTitle", { data });
      this.$refs.dialog.hide();
    },
    addLike() {
      const data = {
        userID: this.$store.state.auth.user.id,
        postID: this.postData.id,
      };
      this.$store.dispatch("post/addLike", data);
    },
  },
};
</script>

<style scoped>
span .block{
  font-size: 16px;
  margin: 0;
}
.post {
  display: flex;
  justify-content: center;
  padding-top: 3%;
}
.post_content {
  margin: auto;
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: 70%;
  background-color: rgba(255, 255, 255, 0.8);
}
.post-title {
  font-size: 18pt;
  color: white;
  width: 100%;
  padding: 10px;
  background-color: rgba(0, 0, 0, 0.5);
  text-transform: uppercase;
}
.descr-title {
  background-color: rgba(0, 0, 0, 0.3);
  width: 300px;
  padding: 5px 0px;
  height: 40px;
  text-align: center;
  position: absolute;
}
.banner-title {
  background-color: rgba(0, 0, 0, 0.4);
  font-size: 16pt;
  color: white;
  position: absolute;
  margin-top: 5px;
  text-align: center;
  width: 300px;
  padding: 5px 0px;
  height: 42px;
}
.banners-content {
  margin-top: 10px;
  min-height: 25px;
  display: flex;
  flex-wrap: wrap;
  justify-content: flex-start;
  width: 100%;
}
.post-descr {
  padding-top: 10px;
  font-size: 14pt;
  color: white;
  text-align: justify;
  background-color: teal;
}
.post-descr p {
  padding: 20px;
}
.post-banners {
  background-color: white;
  display: flex;
  text-align: center;
  padding-bottom: 25px;
}

.user-menu {
  height: 30px;
  top: 46.5%;
}
.btns {
  width: 200px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
.btns .q-btn {
  margin-top: 10px;
}
.form-div {
  margin: auto;
  width: 100%;
  background-color: rgba(255, 255, 255, 1);
}
.empty-banners {
  margin-top: 75px;
  width: 100%;
  font-size: 16pt;
  text-align: center;
}
@media (max-width: 650px) {
  .banner {
    width: 100%;
  }
}
</style>