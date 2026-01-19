<template>
  <div class="page-wrapper">
    <b-card
      :header="village && `Деревня ${village.name}`"
      class="big-card shadow"
    >
      <b-list-group v-if="village !== null">
        <b-list-group-item
          v-for="villager in village.villagers"
          :key="villager.id"
          button
          @click="onClickVillager(villager.id)"
        >
          <b-container fluid>
            <b-row class="align-items-center">
              <b-col cols="8">
                <villager-list-item :villager="villager" />
              </b-col>
              <b-col cols="2" class="d-flex justify-content-center">
                <b-button
                  variant="primary"
                  @click.stop="onClickUpdate(villager.id)"
                >
                  <b-icon icon="pencil" />
                </b-button>
              </b-col>
              <b-col cols="2" class="d-flex justify-content-center">
                <b-button variant="danger" @click.stop="onDelete(villager.id)">
                  <b-icon icon="trash" />
                </b-button>
              </b-col>
            </b-row>
          </b-container>
        </b-list-group-item>
        <b-list-group-item
          class="d-flex align-items-center"
          button
          @click="onClickCreate()"
        >
          <b-container fluid> Создать нового жителя </b-container>
        </b-list-group-item>
      </b-list-group>
      <template v-if="loading">
        <p>Loading...</p>
      </template>
      <template v-if="error !== null">
        <p>Error! {{ error }}</p>
      </template>
    </b-card>
  </div>
</template>

<script>
import { deleteVillagerById } from "../api/villagers";
import { getVillageById } from "../api/villages";
import VillagerListItem from "../components/VillagerListItem.vue";

export default {
  props: ["id"],
  data() {
    return {
      village: null,
      loading: false,
      error: null,
    };
  },
  created() {
    this.loadVillage();
  },
  methods: {
    async loadVillage() {
      this.loading = true;
      this.error = null;

      try {
        const res = await getVillageById(this.id);
        this.village = res.data;
      } catch (e) {
        this.error = `Failed to load village with id = ${this.id}`;
        console.error(e);
      } finally {
        this.loading = false;
      }
    },
    async onDelete(villagerId) {
      await deleteVillagerById(villagerId);
      this.loadVillage();
    },
    onClickUpdate(villagerId) {
      this.$router.push(
        `/villages/${this.village.id}/villagers/${villagerId}/update`
      );
    },
    onClickCreate() {
      this.$router.push(`/villages/${this.village.id}/villagers/create`);
    },
    onClickVillager(villagerId) {
      this.$router.push(`/villagers/${villagerId}`);
    },
  },
  components: {
    VillagerListItem,
  },
};
</script>
