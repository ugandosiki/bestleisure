<template>
  <div class="cabinet">
    <div class="cabinet_content">
      <div class="user">
        <div class="user-info shadow-2 q-mt-sm q-mt-md q-ml-sm">
          <div class="user-info_title">
            <h6>Информация о пользователе</h6>
          </div>
          <div class="user-info_content">
            Имя(ник): <strong>Владислав</strong> Почтовый адрес:
            <strong>vladkolomiets2012@gmail.com</strong> Страна:
            <strong>Украина</strong> Город: <strong>Донецк</strong>
          </div>
        </div>
        <div class="user-actions shadow-2 q-mt-sm q-mt-md q-ml-sm">
          <div class="user-actions_title">
            <h6>Действия c аккаунтом</h6>
          </div>
          <div class="user-actions_content">
            <button class="action-btn shadow-2 q-pa-sm">Изменить пароль</button>
            <button class="action-btn shadow-2 q-pa-sm">Изменить город</button>
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
            />
            <q-btn
              color="teal-6"
              icon="add"
              label="Добавить новую страну"
              size="12px"
            />
            <q-btn
              color="teal-6"
              icon="add"
              label="Добавить новый город"
              size="12px"
            />
            <q-btn
              color="red"
              icon="delete"
              label="Удалить запись"
              size="12px"
            />
          </q-btn-group>
          <hr />
          <h6>Ваши записи</h6>
          <div class="posts-content">
            <post-component />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import PostComponent from "../catalog/PostComponent.vue";
export default {
  name: "CabinetComponent",
  components: { PostComponent },
};
</script>

<style scoped>
.cabinet {
  display: flex;
  justify-content: center;
}
h6 {
  margin-bottom: 10px;
  text-align: center;
  margin-top: 20px;
}
.cabinet_content {
    border-radius: 3px;
  background: rgba(255, 255, 255, 0.8);
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